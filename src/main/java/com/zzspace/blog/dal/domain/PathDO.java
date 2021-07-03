package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class PathDO implements Serializable {
    /**
     * id (19)必填<br>
     *主键
     */ 
    private Long id;

    /**
     * path (255)必填<br>
     *父文件夹所在的路径
     */ 
    private String path;

    /**
     * parent_id (19)<br>
     *
     */ 
    private Long parentId;

    private static final long serialVersionUID = 1L;

    /**
     * id (19)必填<br>
     * 获得 主键
     */ 
    public Long getId() {
        return id;
    }

    public PathDO withId(Long id) {
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
     * path (255)必填<br>
     * 获得 父文件夹所在的路径
     */ 
    public String getPath() {
        return path;
    }

    public PathDO withPath(String path) {
        this.setPath(path);
        return this;
    }

    /**
     * path (255)必填<br>
     * 设置 父文件夹所在的路径
     */ 
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * parent_id (19)<br>
     * 获得 
     */ 
    public Long getParentId() {
        return parentId;
    }

    public PathDO withParentId(Long parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * parent_id (19)<br>
     * 设置 
     */ 
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", path=").append(path);
        sb.append(", parentId=").append(parentId);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        path("path", "path", "VARCHAR", true),
        parentId("parent_id", "parentId", "BIGINT", false);

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