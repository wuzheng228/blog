package com.zzspace.blog.model.query;

import java.io.Serializable;

/**
 * Created by 76973 on 2021/6/6 14:18
 */
public class BlogQuery extends Pageable implements Serializable {

    private String title;
    private Integer typeId;
    private Long tagId;
    private boolean recommend;

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

    public boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public boolean isRecommend() {
        return recommend;
    }


}
