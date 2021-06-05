package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UserDO implements Serializable {
    /**
     * id (10)必填<br>
     *用户id
     */ 
    private Integer id;

    /**
     * username (50)必填<br>
     *用户名
     */ 
    private String username;

    /**
     * password (50)必填<br>
     *密码
     */ 
    private String password;

    /**
     * email (50)必填<br>
     *email
     */ 
    private String email;

    /**
     * right (50)必填<br>
     *权限
     */ 
    private String right;

    /**
     * avatar (255)必填<br>
     *头像
     */ 
    private String avatar;

    /**
     * gmt_created (19)<br>
     *创建时间
     */ 
    private Date gmtCreated;

    /**
     * gmt_modified (19)<br>
     *更新时间
     */ 
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    /**
     * id (10)必填<br>
     * 获得 用户id
     */ 
    public Integer getId() {
        return id;
    }

    public UserDO withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * id (10)必填<br>
     * 设置 用户id
     */ 
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * username (50)必填<br>
     * 获得 用户名
     */ 
    public String getUsername() {
        return username;
    }

    public UserDO withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * username (50)必填<br>
     * 设置 用户名
     */ 
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * password (50)必填<br>
     * 获得 密码
     */ 
    public String getPassword() {
        return password;
    }

    public UserDO withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * password (50)必填<br>
     * 设置 密码
     */ 
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * email (50)必填<br>
     * 获得 email
     */ 
    public String getEmail() {
        return email;
    }

    public UserDO withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * email (50)必填<br>
     * 设置 email
     */ 
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * right (50)必填<br>
     * 获得 权限
     */ 
    public String getRight() {
        return right;
    }

    public UserDO withRight(String right) {
        this.setRight(right);
        return this;
    }

    /**
     * right (50)必填<br>
     * 设置 权限
     */ 
    public void setRight(String right) {
        this.right = right;
    }

    /**
     * avatar (255)必填<br>
     * 获得 头像
     */ 
    public String getAvatar() {
        return avatar;
    }

    public UserDO withAvatar(String avatar) {
        this.setAvatar(avatar);
        return this;
    }

    /**
     * avatar (255)必填<br>
     * 设置 头像
     */ 
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * gmt_created (19)<br>
     * 获得 创建时间
     */ 
    public Date getGmtCreated() {
        return gmtCreated;
    }

    public UserDO withGmtCreated(Date gmtCreated) {
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
     * 获得 更新时间
     */ 
    public Date getGmtModified() {
        return gmtModified;
    }

    public UserDO withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * gmt_modified (19)<br>
     * 设置 更新时间
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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", right=").append(right);
        sb.append(", avatar=").append(avatar);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        username("username", "username", "VARCHAR", false),
        password("password", "password", "VARCHAR", true),
        email("email", "email", "VARCHAR", false),
        right("right", "right", "VARCHAR", true),
        avatar("avatar", "avatar", "VARCHAR", false),
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