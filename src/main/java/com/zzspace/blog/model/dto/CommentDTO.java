package com.zzspace.blog.model.dto;

import com.zzspace.blog.common.anno.DateFormat;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 76973 on 2021/6/23 22:34
 */
public class CommentDTO implements Serializable {
    private Long id;
    private Long blogId;
    private String avatar;
    private Long parentCommentId;
    private String parentName;
    private String nickname;
    private String content;
    private String email;
    private boolean adminComment;
    private List<CommentDTO> children;
    @DateFormat
    private String gmtCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }

    public List<CommentDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CommentDTO> children) {
        this.children = children;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "blogId=" + blogId +
                ", parentCommentId=" + parentCommentId +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", gmtCreated='" + gmtCreated + '\'' +
                '}';
    }
}
