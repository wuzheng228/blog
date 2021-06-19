package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class BlogTagDO implements Serializable {
    /**
     * tag_id (19)必填<br>
     *标签id
     */ 
    private Long tagId;

    /**
     * blog_id (19)必填<br>
     *博客id
     */ 
    private Long blogId;

    private static final long serialVersionUID = 1L;

    /**
     * tag_id (19)必填<br>
     * 获得 标签id
     */ 
    public Long getTagId() {
        return tagId;
    }

    public BlogTagDO withTagId(Long tagId) {
        this.setTagId(tagId);
        return this;
    }

    /**
     * tag_id (19)必填<br>
     * 设置 标签id
     */ 
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * blog_id (19)必填<br>
     * 获得 博客id
     */ 
    public Long getBlogId() {
        return blogId;
    }

    public BlogTagDO withBlogId(Long blogId) {
        this.setBlogId(blogId);
        return this;
    }

    /**
     * blog_id (19)必填<br>
     * 设置 博客id
     */ 
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", blogId=").append(blogId);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        tagId("tag_id", "tagId", "BIGINT", false),
        blogId("blog_id", "blogId", "BIGINT", false);

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