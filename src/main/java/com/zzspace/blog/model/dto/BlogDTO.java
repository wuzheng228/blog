package com.zzspace.blog.model.dto;

import com.zzspace.blog.common.anno.DateFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 76973 on 2021/6/6 8:31
 */
public class BlogDTO implements Serializable {
    private Long id;
    private String title;
    private Integer typeId;
    private TypeDTO type;
    private String tagsIds;
    private Integer userId;
    private String username;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer view;
    private boolean appreciationOn;
    private boolean copyrightOn;
    private boolean recommend;
    private boolean commentOn;
    private boolean realeased;
    private boolean isDeleted;
    @DateFormat
    private String gmtCreated;
    @DateFormat
    private String gmtModified;

    public BlogDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public String getTagsIds() {
        return tagsIds;
    }

    public void setTagsIds(String tagsIds) {
        this.tagsIds = tagsIds;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public boolean getAppreciationOn() {
        return appreciationOn;
    }

    public void setAppreciationOn(boolean appreciationOn) {
        this.appreciationOn = appreciationOn;
    }

    public boolean getCopyrightOn() {
        return copyrightOn;
    }

    public void setCopyrightOn(boolean copyrightOn) {
        this.copyrightOn = copyrightOn;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean getCommentOn() {
        return commentOn;
    }

    public void setCommentOn(boolean commentOn) {
        this.commentOn = commentOn;
    }

    public boolean getRealeased() {
        return realeased;
    }

    public void setRealeased(boolean realeased) {
        this.realeased = realeased;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

}
