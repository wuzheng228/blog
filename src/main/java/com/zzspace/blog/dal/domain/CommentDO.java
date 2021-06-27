package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CommentDO implements Serializable {
    /**
     * id (19)必填<br>
     *
     */ 
    private Long id;

    /**
     * blog_id (19)必填<br>
     *博客id
     */ 
    private Long blogId;

    /**
     * nickname (50)必填<br>
     *昵称
     */ 
    private String nickname;

    /**
     * email (50)必填<br>
     *邮箱
     */ 
    private String email;

    /**
     * avatar (255)<br>
     *头像
     */ 
    private String avatar;

    /**
     * content (255)必填<br>
     *内容
     */ 
    private String content;

    /**
     * parent_comment_id (19)<br>
     *父评论id
     */ 
    private Long parentCommentId;

    /**
     * admin_comment (1)<br>
     *
     */ 
    private Boolean adminComment;

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
     * 获得 
     */ 
    public Long getId() {
        return id;
    }

    public CommentDO withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * id (19)必填<br>
     * 设置 
     */ 
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * blog_id (19)必填<br>
     * 获得 博客id
     */ 
    public Long getBlogId() {
        return blogId;
    }

    public CommentDO withBlogId(Long blogId) {
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

    /**
     * nickname (50)必填<br>
     * 获得 昵称
     */ 
    public String getNickname() {
        return nickname;
    }

    public CommentDO withNickname(String nickname) {
        this.setNickname(nickname);
        return this;
    }

    /**
     * nickname (50)必填<br>
     * 设置 昵称
     */ 
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * email (50)必填<br>
     * 获得 邮箱
     */ 
    public String getEmail() {
        return email;
    }

    public CommentDO withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * email (50)必填<br>
     * 设置 邮箱
     */ 
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * avatar (255)<br>
     * 获得 头像
     */ 
    public String getAvatar() {
        return avatar;
    }

    public CommentDO withAvatar(String avatar) {
        this.setAvatar(avatar);
        return this;
    }

    /**
     * avatar (255)<br>
     * 设置 头像
     */ 
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * content (255)必填<br>
     * 获得 内容
     */ 
    public String getContent() {
        return content;
    }

    public CommentDO withContent(String content) {
        this.setContent(content);
        return this;
    }

    /**
     * content (255)必填<br>
     * 设置 内容
     */ 
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * parent_comment_id (19)<br>
     * 获得 父评论id
     */ 
    public Long getParentCommentId() {
        return parentCommentId;
    }

    public CommentDO withParentCommentId(Long parentCommentId) {
        this.setParentCommentId(parentCommentId);
        return this;
    }

    /**
     * parent_comment_id (19)<br>
     * 设置 父评论id
     */ 
    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    /**
     * admin_comment (1)<br>
     * 获得 
     */ 
    public Boolean getAdminComment() {
        return adminComment;
    }

    public CommentDO withAdminComment(Boolean adminComment) {
        this.setAdminComment(adminComment);
        return this;
    }

    /**
     * admin_comment (1)<br>
     * 设置 
     */ 
    public void setAdminComment(Boolean adminComment) {
        this.adminComment = adminComment;
    }

    /**
     * gmt_created (19)<br>
     * 获得 创建时间
     */ 
    public Date getGmtCreated() {
        return gmtCreated;
    }

    public CommentDO withGmtCreated(Date gmtCreated) {
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

    public CommentDO withGmtModified(Date gmtModified) {
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
        sb.append(", blogId=").append(blogId);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", avatar=").append(avatar);
        sb.append(", content=").append(content);
        sb.append(", parentCommentId=").append(parentCommentId);
        sb.append(", adminComment=").append(adminComment);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        blogId("blog_id", "blogId", "BIGINT", false),
        nickname("nickname", "nickname", "VARCHAR", false),
        email("email", "email", "VARCHAR", false),
        avatar("avatar", "avatar", "VARCHAR", false),
        content("content", "content", "VARCHAR", false),
        parentCommentId("parent_comment_id", "parentCommentId", "BIGINT", false),
        adminComment("admin_comment", "adminComment", "BIT", false),
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