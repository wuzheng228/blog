package com.zzspace.blog.model.dto;

import com.zzspace.blog.common.anno.DateFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 76973 on 2021/7/1 20:59
 */
public class FileDTO implements Serializable {

    private Long id;
    private String name;
    private String type;
    private boolean dir;
    private String path;
    private Long parentId;
    @DateFormat
    private String gmtCreated;
    @DateFormat
    private String gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDir() {
        return dir;
    }

    public void setDir(boolean dir) {
        this.dir = dir;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
