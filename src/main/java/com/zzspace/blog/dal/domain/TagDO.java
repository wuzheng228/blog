package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class TagDO implements Serializable {
    /**
     * id (19)必填<br>
     *标签id
     */ 
    private Long id;

    /**
     * name (20)<br>
     *标签名
     */ 
    private String name;

    private static final long serialVersionUID = 1L;

    /**
     * id (19)必填<br>
     * 获得 标签id
     */ 
    public Long getId() {
        return id;
    }

    public TagDO withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * id (19)必填<br>
     * 设置 标签id
     */ 
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * name (20)<br>
     * 获得 标签名
     */ 
    public String getName() {
        return name;
    }

    public TagDO withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * name (20)<br>
     * 设置 标签名
     */ 
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        name("name", "name", "VARCHAR", true);

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