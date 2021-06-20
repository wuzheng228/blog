package com.zzspace.blog.service;

import com.zzspace.blog.common.strategy.impl.DateFormaters;
import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.common.util.MarkdownUtils;
import com.zzspace.blog.dal.domain.*;
import com.zzspace.blog.dal.repository.*;
import com.zzspace.blog.model.dto.BlogDTO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TagDTO;
import com.zzspace.blog.model.dto.TypeDTO;
import com.zzspace.blog.model.query.BlogQuery;
import com.zzspace.blog.model.query.Pageable;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 76973 on 2021/6/6 8:29
 */
@Service
public class BlogService {
    @Resource
    private TypeRepository repository;
    @Resource
    private BlogRepository blogRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private BlogTagRepository blogTagRepository;
    @Resource
    private TagRepository tagRepository;
    /**
     * 分页查询博客信息
     */
    public PageDTO<BlogDTO> listBlog(BlogQuery blogQuery) {
        Long total = blogRepository.countBlogNotDeleted();
        List<BlogDO> blogDOS = blogRepository.listBlog(blogQuery);
        if (blogQuery.getTagId() != null) {
            List<BlogDO> res = new ArrayList<>();
           blogDOS.forEach(o -> {
                List<BlogTagDO> blogTagDOS = blogTagRepository.selectByBlogId(o.getId());
                List<Long> tagIds = blogTagDOS.stream().map(BlogTagDO::getTagId).collect(Collectors.toList());
                if (tagIds.contains(blogQuery.getTagId())) {
                    res.add(o);
                }
            });
           blogDOS = res;
        }
        List<BlogDTO> blogDTOS = ConvertUtils.convertList(blogDOS, BlogDTO.class);
        PageDTO<BlogDTO> pageDTO = new PageDTO<>(blogQuery, total);
        for (int i = 0; i < blogDOS.size(); i++) {
            BlogDTO each = blogDTOS.get(i);
            TypeDO typeDO = repository.findTypeById(each.getTypeId());
            blogDTOS.get(i).setType(ConvertUtils.convert(typeDO, TypeDTO.class));
            UserDO user = userRepository.findUserById(each.getUserId());
            blogDTOS.get(i).setUsername(user.getUsername());
            List<BlogTagDO> blogTagDOS = blogTagRepository.selectByBlogId(each.getId());
            List<String> tagNames = new ArrayList<>();
            for (BlogTagDO blogTagDO : blogTagDOS) {
                TagDO tagDO = tagRepository.selectByPrimaryKey(blogTagDO.getTagId());
                tagNames.add(tagDO.getName());
            }
            each.setTagNames(tagNames);
        }
        pageDTO.setPageData(blogDTOS);
        return pageDTO;
    }

    /**
     * 查找该博客含有的标签
     */
    public List<TagDTO> listTagByBlogId(Long id) {
        List<BlogTagDO> blogTagDOS = blogTagRepository.selectByBlogId(id);
        if (CollectionUtils.isNotEmpty(blogTagDOS)) {
            return blogTagDOS.stream().map(o -> {
                Long tagId = o.getTagId();
                TagDO tagDO = tagRepository.selectByPrimaryKey(tagId);
                return ConvertUtils.convert(tagDO, TagDTO.class);
            }).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 分页查询主页博客信息
     */
    public PageDTO<BlogDTO> queryIndexInfo(Pageable pageable) {
        List<BlogDO> blogDOS = blogRepository.queryIndexInfo(pageable);
        List<BlogDTO> blogDTOS = ConvertUtils.convertList(blogDOS, BlogDTO.class, DateFormaters.yyyy_MM_dd);
        blogDTOS.forEach((o)->{
            TypeDO typeDO = repository.findTypeById(o.getTypeId());
            o.setType(ConvertUtils.convert(typeDO,TypeDTO.class));
            UserDO user = userRepository.findUserById(o.getUserId());
            o.setUsername(user.getUsername());
        });
        PageDTO<BlogDTO> pageDTO = new PageDTO<>(pageable, (long) blogDTOS.size());
        pageDTO.setPageData(blogDTOS);
        return pageDTO;
    }

    /**
     * 更新保存博客内容
     */
    @Transactional
    public int upsertBlog(BlogDTO blogDTO) {
        BlogDO blog = ConvertUtils.convert(blogDTO, BlogDO.class);
        Long blogId = blog.getId();
        if (blogId != null) {
            List<BlogTagDO> blogTagDOS =  blogTagRepository.selectByBlogId(blogId);
            List<Long> originalTagIds = blogTagDOS.stream().map(BlogTagDO::getTagId).collect(Collectors.toList());
            String tagsIds = blogDTO.getTagsIds();
            List<Long> updatedTagIds = new ArrayList<>();
            if (StringUtils.isNotBlank(tagsIds)) {
                updatedTagIds = Arrays.stream(tagsIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            }
            Collection<Long> needToDeletes = CollectionUtils.removeAll(originalTagIds, updatedTagIds);
            Collection<Long> needToInserts = CollectionUtils.removeAll(updatedTagIds, originalTagIds);
            for (Long each : needToDeletes) {
                blogTagRepository.deleteByTagId(each);
            }
            for (Long each : needToInserts) {
                BlogTagDO blogTagDO = new BlogTagDO();
                blogTagDO.setBlogId(blog.getId());
                blogTagDO.setTagId(each);
                blogTagRepository.save(blogTagDO);
            }
            return blogRepository.updateBlogById(blog);
        }
        int num = blogRepository.insertBlog(blog);
        Long[] tagsIds = Arrays.stream( blogDTO.getTagsIds().split(",")).map(Long::parseLong).toArray(Long[]::new);
        for (Long tagId : tagsIds) {
            BlogTagDO blogTagDO = new BlogTagDO();
            blogTagDO.setBlogId(blog.getId());
            blogTagDO.setTagId(tagId);
            blogTagRepository.save(blogTagDO);
        }
        return num;
    }

    /**
     * 根据id删除博客
     */
    @Transactional
    public int deleteBlogById(long id) {
        blogTagRepository.deleteBybBlogId(id);
        return  blogRepository.deleteBlogById(id);
    }

    /**
     * 根据id查找博客
     */
    public BlogDTO findBlogById(Long id, boolean needParsed) {
        BlogDO blogDO = blogRepository.findBlogById(id);
        BlogDTO convert = ConvertUtils.convert(blogDO, BlogDTO.class, DateFormaters.yyyy_MM_dd_HH_mm_ss);
        if (needParsed) {
            String content = MarkdownUtils.markdown2HtmlExtensions(convert.getContent());
            convert.setContent(content);
        }
        return convert;
    }

    /**
     * 查找前k个推荐文章 按更新时间排序
     */
    public List<BlogDTO> findTopKRecommend(int topk) {
        List<BlogDO> blogDOS = blogRepository.findTopKRecommend(topk);
        return ConvertUtils.convertList(blogDOS, BlogDTO.class);
    }

    /**
     * 全文搜索博文关键字查找博客
     */
    public PageDTO<BlogDTO> listBlogByPattern(String query, Pageable pageable) {
        List<BlogDO>  blogDOS =  blogRepository.listBlogByPattern(query, pageable);
        List<BlogDTO> blogDTOS = ConvertUtils.convertList(blogDOS, BlogDTO.class, DateFormaters.yyyy_MM_dd_HH_mm_ss);
        blogDTOS.forEach(o-> {
            TypeDO typeDO = repository.findTypeById(o.getTypeId());
            o.setType(ConvertUtils.convert(typeDO,TypeDTO.class));
            UserDO user = userRepository.findUserById(o.getUserId());
            o.setUsername(user.getUsername());
        });
        PageDTO<BlogDTO> pageDTO = new PageDTO<>(pageable, (long) blogDOS.size());
        pageDTO.setPageData(blogDTOS);
        return pageDTO;
    }

    public PageDTO<BlogDTO> listBlogByLike(String query, Pageable pageable) {
        List<BlogDO>  blogDOS =  blogRepository.listBlogByLike(query, pageable);
        List<BlogDTO> blogDTOS = ConvertUtils.convertList(blogDOS, BlogDTO.class, DateFormaters.yyyy_MM_dd_HH_mm_ss);
        blogDTOS.forEach(o-> {
            TypeDO typeDO = repository.findTypeById(o.getTypeId());
            o.setType(ConvertUtils.convert(typeDO,TypeDTO.class));
            UserDO user = userRepository.findUserById(o.getUserId());
            o.setUsername(user.getUsername());
        });
        PageDTO<BlogDTO> pageDTO = new PageDTO<>(pageable, (long) blogDOS.size());
        pageDTO.setPageData(blogDTOS);
        return pageDTO;
    }

}
