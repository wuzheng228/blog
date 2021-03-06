package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.dal.domain.BlogExample;
import com.zzspace.blog.dal.mapper.BlogMapper;
import com.zzspace.blog.dao.BlogDAO;
import com.zzspace.blog.model.query.BlogQuery;
import com.zzspace.blog.model.query.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/6 8:30
 */
@Repository
public class BlogRepository extends BaseRepository<BlogDO> {
    @Resource
    private BlogMapper blogMapper;
    @Resource
    private BlogDAO blogDAO;

    public List<BlogDO> listBlogByCondition(BlogQuery blogQuery) {
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
        example.setOrderByClause("gmt_modified desc");
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

    public List<BlogDO> queryIndexInfo(Pageable pageable) {
        BlogExample example = new BlogExample();
        example.createCriteria().andIsDeletedEqualTo(false).andRealeasedEqualTo(true);
        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());
        example.setOrderByClause("gmt_modified desc");
        return blogMapper.selectByExample(example);
    }

    public long countBlogByTypeId(Integer id) {
        BlogExample example = new BlogExample();
        BlogExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false).andRealeasedEqualTo(true);
        if (id != null) {
            criteria .andTypeIdEqualTo(id);
        }
        return blogMapper.countByExample(example);
    }

    public List<BlogDO> findTopKRecommend(int k) {
        BlogExample example = new BlogExample();
        example.createCriteria().andIsDeletedEqualTo(false).andAppreciationOnEqualTo(true)
        .andRealeasedEqualTo(true);
        example.setOrderByClause("gmt_modified desc");
        example.setOffset(0);
        example.setLimit(k);
        return blogMapper.selectByExample(example);
    }

    public List<BlogDO> listBlogByPattern(String query, Pageable pageable) {
        BlogExample example = new BlogExample();
        example.createCriteria().andIsDeletedEqualTo(false)
                .andRealeasedEqualTo(true)
                .andCustomCriterion(String.format("MATCH(title, content) AGAINST('%s')", query));
        example.setLimit(pageable.getLimit());
        example.setOffset(pageable.getOffset());
        return blogMapper.selectByExample(example);
    }

    public List<BlogDO> listBlogByLike(String query, Pageable pageable) {
        BlogExample example = new BlogExample();
        example.createCriteria().andIsDeletedEqualTo(false)
                .andRealeasedEqualTo(true)
                .andCustomCriterion("content like '%" + query + "%'");
        example.or().andIsDeletedEqualTo(false)
                .andRealeasedEqualTo(true)
                .andTitleLike("'%" + query + "%'");
        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());
        example.setOrderByClause("gmt_modified desc");
        return blogMapper.selectByExample(example);
    }

    public Long countBlogByDeleteAndRelease() {
        BlogExample example = new BlogExample();
        example.createCriteria().andIsDeletedEqualTo(false).andRealeasedEqualTo(true);
        return blogMapper.countByExample(example);
    }

    public int updateNullByTagId(Integer id) {
        return blogDAO.updateNullByTagId(id);
    }

    public List<BlogDO> listBlogByType(Integer typeId) {
        BlogExample example = new BlogExample();
        BlogExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false)
                .andRealeasedEqualTo(true);
        if (typeId != null) {
            criteria.andTypeIdEqualTo(typeId);
        }
        return blogMapper.selectByExample(example);
    }
}
