package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.BlogTagDO;
import com.zzspace.blog.dal.domain.BlogTagExample;
import com.zzspace.blog.dal.mapper.BlogTagMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/18 17:50
 */
@Repository
public class BlogTagRepository extends BaseRepository<BlogTagDO> {

    @Resource
    private BlogTagMapper blogTagMapper;

    public Integer deleteByTagId(Long id) {
        BlogTagExample blogTagExample = new BlogTagExample();
        blogTagExample.createCriteria().andTagIdEqualTo(id);
        return blogTagMapper.deleteByExample(blogTagExample);
    }

    public Integer deleteBybBlogId(Long id) {
        BlogTagExample blogTagExample = new BlogTagExample();
        blogTagExample.createCriteria().andBlogIdEqualTo(id);
        return blogTagMapper.deleteByExample(blogTagExample);
    }

    public List<BlogTagDO> selectByBlogId(Long id) {
        BlogTagExample blogTagExample = new BlogTagExample();
        blogTagExample.createCriteria().andBlogIdEqualTo(id);
        return blogTagMapper.selectByExample(blogTagExample);
    }

    public Long coutByTagId(Long id) {
        BlogTagExample e = new BlogTagExample();
        e.createCriteria().andTagIdEqualTo(id);
        return blogTagMapper.countByExample(e);
    }
}
