package com.zzspace.blog.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 76973 on 2021/7/3 11:42
 */
public class CrumbDTO implements Serializable {
    private String name;// 当前文件（夹）的名字
    private Long parentId = -1L;// 父文件夹的Id

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

    @Override
    public String toString() {
        return "CrumbDTO{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
