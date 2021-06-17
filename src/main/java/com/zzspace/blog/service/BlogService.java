package com.zzspace.blog.service;

import com.zzspace.blog.common.strategy.impl.DateFormaters;
import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.common.util.MarkdownUtils;
import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.dal.domain.UserDO;
import com.zzspace.blog.dal.repository.BlogRepository;
import com.zzspace.blog.dal.repository.TypeRepository;
import com.zzspace.blog.dal.repository.UserRepository;
import com.zzspace.blog.model.dto.BlogDTO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TypeDTO;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.model.query.BlogQuery;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 分页查询博客信息
     */
    public PageDTO<BlogDTO> listBlog(BlogQuery blogQuery) {
        Long total = blogRepository.countBlogNotDeleted();
        List<BlogDO> blogDOS = blogRepository.listBlog(blogQuery);
        List<BlogDTO> blogDTOS = ConvertUtils.convertList(blogDOS, BlogDTO.class);
        PageDTO<BlogDTO> pageDTO = new PageDTO<>(blogQuery, total);
        for (int i = 0; i < blogDOS.size(); i++) {
            BlogDO each = blogDOS.get(i);
            TypeDO typeDO = repository.findTypeById(each.getTypeId());
            blogDTOS.get(i).setType(ConvertUtils.convert(typeDO, TypeDTO.class));
            UserDO user = userRepository.findUserById(each.getUserId());
            blogDTOS.get(i).setUsername(user.getUsername());
        }
        pageDTO.setPageData(blogDTOS);
        return pageDTO;
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
    public int upsertBlog(BlogDTO blogDTO) {
        BlogDO blog = ConvertUtils.convert(blogDTO, BlogDO.class);
        Long id = blog.getId();
        if (id != null) {
            return blogRepository.updateBlogById(blog);
        }
        return blogRepository.insertBlog(blog);
    }

    /**
     * 根据id删除博客
     */
    public int deleteBlogById(long id) {
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
