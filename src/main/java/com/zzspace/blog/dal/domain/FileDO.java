package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class FileDO implements Serializable {
    /**
     * id (19)必填<br>
     *主键
     */ 
    private Long id;

    /**
     * name (50)必填<br>
     *文件名
     */ 
    private String name;

    /**
     * type (50)必填<br>
     *文件类型
     */ 
    private String type;

    /**
     * dir (1)必填<br>
     *是否是文件夹
     */ 
    private Boolean dir;

    /**
     * path (255)<br>
     *文件路径
     */ 
    private String path;

    /**
     * parent_id (19)<br>
     *父文件夹id
     */ 
    private Long parentId;

    /**
     * gmt_created (19)<br>
     *创建时间
     */ 
    private Date gmtCreated;

    /**
     * gmt_modified (19)<br>
     *修改时间
     */ 
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    /**
     * id (19)必填<br>
     * 获得 主键
     */ 
    public Long getId() {
        return id;
    }

    public FileDO withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * id (19)必填<br>
     * 设置 主键
     */ 
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * name (50)必填<br>
     * 获得 文件名
     */ 
    public String getName() {
        return name;
    }

    public FileDO withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * name (50)必填<br>
     * 设置 文件名
     */ 
    public void setName(String name) {
        this.name = name;
    }

    /**
     * type (50)必填<br>
     * 获得 文件类型
     */ 
    public String getType() {
        return type;
    }

    public FileDO withType(String type) {
        this.setType(type);
        return this;
    }

    /**
     * type (50)必填<br>
     * 设置 文件类型
     */ 
    public void setType(String type) {
        this.type = type;
    }

    /**
     * dir (1)必填<br>
     * 获得 是否是文件夹
     */ 
    public Boolean getDir() {
        return dir;
    }

    public FileDO withDir(Boolean dir) {
        this.setDir(dir);
        return this;
    }

    /**
     * dir (1)必填<br>
     * 设置 是否是文件夹
     */ 
    public void setDir(Boolean dir) {
        this.dir = dir;
    }

    /**
     * path (255)<br>
     * 获得 文件路径
     */ 
    public String getPath() {
        return path;
    }

    public FileDO withPath(String path) {
        this.setPath(path);
        return this;
    }

    /**
     * path (255)<br>
     * 设置 文件路径
     */ 
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * parent_id (19)<br>
     * 获得 父文件夹id
     */ 
    public Long getParentId() {
        return parentId;
    }

    public FileDO withParentId(Long parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * parent_id (19)<br>
     * 设置 父文件夹id
     */ 
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * gmt_created (19)<br>
     * 获得 创建时间
     */ 
    public Date getGmtCreated() {
        return gmtCreated;
    }

    public FileDO withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * gmt_created (19)<br>
     * 设置 创建时间
     */ 
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * gmt_modified (19)<br>
     * 获得 修改时间
     */ 
    public Date getGmtModified() {
        return gmtModified;
    }

    public FileDO withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * gmt_modified (19)<br>
     * 设置 修改时间
     */ 
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", dir=").append(dir);
        sb.append(", path=").append(path);
        sb.append(", parentId=").append(parentId);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        type("type", "type", "VARCHAR", true),
        dir("dir", "dir", "BIT", false),
        path("path", "path", "VARCHAR", true),
        parentId("parent_id", "parentId", "BIGINT", false),
        gmtCreated("gmt_created", "gmtCreated", "TIMESTAMP", false),
        gmtModified("gmt_modified", "gmtModified", "TIMESTAMP", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}