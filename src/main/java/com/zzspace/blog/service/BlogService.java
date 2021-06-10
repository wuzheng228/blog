package com.zzspace.blog.service;

import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.dal.repository.BlogRepository;
import com.zzspace.blog.dal.repository.TypeRepository;
import com.zzspace.blog.model.dto.BlogDTO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TypeDTO;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.model.query.BlogQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/6 8:29
 */
@Service
public class BlogService {

    @Resource
    private BlogRepository blogRepository;
    @Resource
    private TypeRepository repository;

    public PageDTO<BlogDTO> listBlog(BlogQuery blogQuery) {
        Long total = blogRepository.countBlogNotDeleted();
        List<BlogDO> blogDOS = blogRepository.listBlog(blogQuery);
        List<BlogDTO> blogDTOS = ConvertUtils.convertList(blogDOS, BlogDTO.class);
        PageDTO<BlogDTO> pageDTO = new PageDTO<>(blogQuery, total);
        for (int i = 0; i < blogDOS.size(); i++) {
            BlogDO each = blogDOS.get(i);
            TypeDO typeDO = repository.findTypeById(each.getTypeId());
            blogDTOS.get(i).setType(ConvertUtils.convert(typeDO, TypeDTO.class));
        }
        pageDTO.setPageData(blogDTOS);
        return pageDTO;
    }

    public int upsertBlog(BlogDTO blogDTO) {
        BlogDO blog = ConvertUtils.convert(blogDTO, BlogDO.class);
        Long id = blog.getId();
        if (id != null) {
            return blogRepository.updateBlogById(blog);
        }
        return blogRepository.insertBlog(blog);
    }

    public int deleteBlogById(long id) {
        return  blogRepository.deleteBlogById(id);
    }

    public BlogDTO findBlogById(Long id) {
        BlogDO blogDO = blogRepository.findBlogById(id);
        return ConvertUtils.convert(blogDO, BlogDTO.class);
    }
}
