package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.dal.domain.BlogExample;
import com.zzspace.blog.dal.mapper.BlogMapper;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.model.query.BlogQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/6 8:30
 */
@Repository
public class BlogRepository {
    @Resource
    private BlogMapper blogMapper;

    public List<BlogDO> listBlog(BlogQuery blogQuery) {
        BlogExample example = new BlogExample();
        BlogExample.Criteria criteria = example.createCriteria();
        String title = blogQuery.getTitle();
        Integer typeId = blogQuery.getTypeId();
        boolean recommend = blogQuery.getRecommend();
        if (StringUtils.isNotBlank(title)) {
            criteria.andCustomCriterion("title like '%" + title +"%'");
        }
        if (typeId != null) {
            criteria.andTypeIdEqualTo(typeId);
        }
        if (recommend) {
            criteria.andRecommendEqualTo(true);
        }
        criteria.andIsDeletedEqualTo(false);
        example.setLimit(blogQuery.getLimit());
        example.setOffset(blogQuery.getOffset());
        return blogMapper.selectByExample(example);
    }

    public int insertBlog(BlogDO blogDO) {
        return blogMapper.insertSelective(blogDO);
    }

    public int updateBlogById(BlogDO blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    public BlogDO findBlogById(Long id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    public Long countBlogNotDeleted() {
        BlogExample example = new BlogExample();
        example.createCriteria().andIsDeletedEqualTo(false);
        return blogMapper.countByExample(example);
    }

    public int deleteBlogById(long id) {
        BlogDO blogDO = new BlogDO();
        blogDO.setId(id);
        blogDO.setIsDeleted(true);
        return blogMapper.updateByPrimaryKeySelective(blogDO);
    }
}
