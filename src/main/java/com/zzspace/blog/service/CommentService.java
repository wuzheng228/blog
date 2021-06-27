package com.zzspace.blog.service;

import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.config.properties.BizProperties;
import com.zzspace.blog.dal.domain.CommentDO;
import com.zzspace.blog.dal.repository.CommentRepository;
import com.zzspace.blog.model.dto.CommentDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76973 on 2021/6/26 13:36
 */
@Service
public class CommentService {

    @Resource
    private BizProperties bizProperties;
    @Resource
    private CommentRepository commentRepository;

    /**
     * 根据blogId查找对应的评论
     */
    public List<CommentDTO> listCommentByBlogId(Long blogId) {
        List<CommentDO> parents = commentRepository.listParentComment(blogId);
        System.out.println(parents);
        List<CommentDTO> converted = ConvertUtils.convertList(parents, CommentDTO.class);
        for (int i = 0; i < converted.size(); i++) {
            CommentDTO parent  = converted.get(i);
            List<CommentDTO> ans = new ArrayList<>();
            listChildren(parent, ans);
            parent.setChildren(ans);
        }
        return converted;
    }

    void listChildren(CommentDTO parent, List<CommentDTO> ans) {
        List<CommentDO> childs = commentRepository.listCommentByParentId(parent.getId());
        List<CommentDTO> converted = ConvertUtils.convertList(childs, CommentDTO.class);
        ans.addAll(converted);
        for (CommentDTO child : converted) {
            child.setParentName(parent.getNickname());
            listChildren(child, ans);
        }
    }

    /**
     * 发布一条评论
     */
    public Integer postComment(CommentDTO commentDTO) {
        CommentDO convert = ConvertUtils.convert(commentDTO, CommentDO.class);
        convert.setAvatar(bizProperties.getTouristAvatar());
        if (convert.getAdminComment()) {
            convert.setAvatar(bizProperties.getAdminAvatar());
        }
        return commentRepository.postComment(convert);
    }
}
