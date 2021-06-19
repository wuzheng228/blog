package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.BlogTagDO;
import com.zzspace.blog.dal.domain.BlogTagExample;
import com.zzspace.blog.dal.mapper.BlogTagMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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

}