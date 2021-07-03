package com.zzspace.blog.model.dto;

import java.io.Serializable;

/**
 * Created by 76973 on 2021/7/3 11:42
 */
public class CrumbDTO implements Serializable {
    private String name;
    private Long parentId = -1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
