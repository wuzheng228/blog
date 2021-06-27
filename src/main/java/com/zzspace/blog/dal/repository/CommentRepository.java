package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.CommentDO;
import com.zzspace.blog.dal.domain.CommentExample;
import com.zzspace.blog.dal.mapper.CommentMapper;
import com.zzspace.blog.model.dto.CommentDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/26 13:43
 */
@Repository
public class CommentRepository extends BaseRepository<CommentDO> {

    @Resource
    private CommentMapper commentMapper;

    public List<CommentDO> listCommentByBlogId(Long id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andBlogIdEqualTo(id);
        example.setOrderByClause("gmt_created asc");
        return commentMapper.selectByExample(example);
    }

    public Integer postComment(CommentDO commentDO) {
        return commentMapper.insertSelective(commentDO);
    }

    public List<CommentDO> listParentComment(Long blogId) {
        CommentExample example = new CommentExample();
        example.createCriteria().andParentCommentIdIsNull().andBlogIdEqualTo(blogId);
        example.setOrderByClause("gmt_created asc");
        return commentMapper.selectByExample(example);
    }

    public List<CommentDO> listCommentByParentId(Long parentId) {
        CommentExample example = new CommentExample();
        example.createCriteria().andParentCommentIdEqualTo(parentId);
        example.setOrderByClause("gmt_created asc");
        return commentMapper.selectByExample(example);
    }
}
