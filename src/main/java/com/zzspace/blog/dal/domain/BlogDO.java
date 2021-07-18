package com.zzspace.blog.dal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BlogDO implements Serializable {
    /**
     * id (19)必填<br>
     *博客id
     */ 
    private Long id;

    /**
     * title (32)必填<br>
     *标题
     */ 
    private String title;

    /**
     * type_id (10)必填<br>
     *类型
     */ 
    private Integer typeId;

    /**
     * user_id (10)必填<br>
     *用户
     */ 
    private Integer userId;

    /**
     * summery (512)<br>
     *
     */ 
    private String summery;

    /**
     * first_picture (255)<br>
     *首图
     */ 
    private String firstPicture;

    /**
     * flag (10)<br>
     *标记:原创、转载、翻译
     */ 
    private String flag;

    /**
     * view (10)默认值 [0]<br>
     *阅读量
     */ 
    private Integer view;

    /**
     * appreciation_on (1)默认值 [b'1']<br>
     *赞赏是否开启
     */ 
    private Boolean appreciationOn;

    /**
     * copyright_on (1)默认值 [b'1']<br>
     *版权是否开启
     */ 
    private Boolean copyrightOn;

    /**
     * recommend (1)默认值 [b'1']<br>
     *是否推荐
     */ 
    private Boolean recommend;

    /**
     * comment_on (1)默认值 [b'1']<br>
     *评论是否开启
     */ 
    private Boolean commentOn;

    /**
     * realeased (1)<br>
     *是否发布
     */ 
    private Boolean realeased;

    /**
     * is_deleted (1)默认值 [b'0']<br>
     *是否逻辑删除
     */ 
    private Boolean isDeleted;

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

    /**
     * content (2147483647)<br>
     *内容
     */ 
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * id (19)必填<br>
     * 获得 博客id
     */ 
    public Long getId() {
        return id;
    }

    public BlogDO withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * id (19)必填<br>
     * 设置 博客id
     */ 
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * title (32)必填<br>
     * 获得 标题
     */ 
    public String getTitle() {
        return title;
    }

    public BlogDO withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    /**
     * title (32)必填<br>
     * 设置 标题
     */ 
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * type_id (10)必填<br>
     * 获得 类型
     */ 
    public Integer getTypeId() {
        return typeId;
    }

    public BlogDO withTypeId(Integer typeId) {
        this.setTypeId(typeId);
        return this;
    }

    /**
     * type_id (10)必填<br>
     * 设置 类型
     */ 
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * user_id (10)必填<br>
     * 获得 用户
     */ 
    public Integer getUserId() {
        return userId;
    }

    public BlogDO withUserId(Integer userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * user_id (10)必填<br>
     * 设置 用户
     */ 
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * summery (512)<br>
     * 获得 
     */ 
    public String getSummery() {
        return summery;
    }

    public BlogDO withSummery(String summery) {
        this.setSummery(summery);
        return this;
    }

    /**
     * summery (512)<br>
     * 设置 
     */ 
    public void setSummery(String summery) {
        this.summery = summery;
    }

    /**
     * first_picture (255)<br>
     * 获得 首图
     */ 
    public String getFirstPicture() {
        return firstPicture;
    }

    public BlogDO withFirstPicture(String firstPicture) {
        this.setFirstPicture(firstPicture);
        return this;
    }

    /**
     * first_picture (255)<br>
     * 设置 首图
     */ 
    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    /**
     * flag (10)<br>
     * 获得 标记:原创、转载、翻译
     */ 
    public String getFlag() {
        return flag;
    }

    public BlogDO withFlag(String flag) {
        this.setFlag(flag);
        return this;
    }

    /**
     * flag (10)<br>
     * 设置 标记:原创、转载、翻译
     */ 
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * view (10)默认值 [0]<br>
     * 获得 阅读量
     */ 
    public Integer getView() {
        return view;
    }

    public BlogDO withView(Integer view) {
        this.setView(view);
        return this;
    }

    /**
     * view (10)默认值 [0]<br>
     * 设置 阅读量
     */ 
    public void setView(Integer view) {
        this.view = view;
    }

    /**
     * appreciation_on (1)默认值 [b'1']<br>
     * 获得 赞赏是否开启
     */ 
    public Boolean getAppreciationOn() {
        return appreciationOn;
    }

    public BlogDO withAppreciationOn(Boolean appreciationOn) {
        this.setAppreciationOn(appreciationOn);
        return this;
    }

    /**
     * appreciation_on (1)默认值 [b'1']<br>
     * 设置 赞赏是否开启
     */ 
    public void setAppreciationOn(Boolean appreciationOn) {
        this.appreciationOn = appreciationOn;
    }

    /**
     * copyright_on (1)默认值 [b'1']<br>
     * 获得 版权是否开启
     */ 
    public Boolean getCopyrightOn() {
        return copyrightOn;
    }

    public BlogDO withCopyrightOn(Boolean copyrightOn) {
        this.setCopyrightOn(copyrightOn);
        return this;
    }

    /**
     * copyright_on (1)默认值 [b'1']<br>
     * 设置 版权是否开启
     */ 
    public void setCopyrightOn(Boolean copyrightOn) {
        this.copyrightOn = copyrightOn;
    }

    /**
     * recommend (1)默认值 [b'1']<br>
     * 获得 是否推荐
     */ 
    public Boolean getRecommend() {
        return recommend;
    }

    public BlogDO withRecommend(Boolean recommend) {
        this.setRecommend(recommend);
        return this;
    }

    /**
     * recommend (1)默认值 [b'1']<br>
     * 设置 是否推荐
     */ 
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * comment_on (1)默认值 [b'1']<br>
     * 获得 评论是否开启
     */ 
    public Boolean getCommentOn() {
        return commentOn;
    }

    public BlogDO withCommentOn(Boolean commentOn) {
        this.setCommentOn(commentOn);
        return this;
    }

    /**
     * comment_on (1)默认值 [b'1']<br>
     * 设置 评论是否开启
     */ 
    public void setCommentOn(Boolean commentOn) {
        this.commentOn = commentOn;
    }

    /**
     * realeased (1)<br>
     * 获得 是否发布
     */ 
    public Boolean getRealeased() {
        return realeased;
    }

    public BlogDO withRealeased(Boolean realeased) {
        this.setRealeased(realeased);
        return this;
    }

    /**
     * realeased (1)<br>
     * 设置 是否发布
     */ 
    public void setRealeased(Boolean realeased) {
        this.realeased = realeased;
    }

    /**
     * is_deleted (1)默认值 [b'0']<br>
     * 获得 是否逻辑删除
     */ 
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public BlogDO withIsDeleted(Boolean isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    /**
     * is_deleted (1)默认值 [b'0']<br>
     * 设置 是否逻辑删除
     */ 
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * gmt_created (19)<br>
     * 获得 创建时间
     */ 
    public Date getGmtCreated() {
        return gmtCreated;
    }

    public BlogDO withGmtCreated(Date gmtCreated) {
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

    public BlogDO withGmtModified(Date gmtModified) {
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

    /**
     * content (2147483647)<br>
     * 获得 内容
     */ 
    public String getContent() {
        return content;
    }

    public BlogDO withContent(String content) {
        this.setContent(content);
        return this;
    }

    /**
     * content (2147483647)<br>
     * 设置 内容
     */ 
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", userId=").append(userId);
        sb.append(", summery=").append(summery);
        sb.append(", firstPicture=").append(firstPicture);
        sb.append(", flag=").append(flag);
        sb.append(", view=").append(view);
        sb.append(", appreciationOn=").append(appreciationOn);
        sb.append(", copyrightOn=").append(copyrightOn);
        sb.append(", recommend=").append(recommend);
        sb.append(", commentOn=").append(commentOn);
        sb.append(", realeased=").append(realeased);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        title("title", "title", "VARCHAR", false),
        typeId("type_id", "typeId", "INTEGER", false),
        userId("user_id", "userId", "INTEGER", false),
        summery("summery", "summery", "VARCHAR", false),
        firstPicture("first_picture", "firstPicture", "VARCHAR", false),
        flag("flag", "flag", "VARCHAR", false),
        view("view", "view", "INTEGER", true),
        appreciationOn("appreciation_on", "appreciationOn", "BIT", false),
        copyrightOn("copyright_on", "copyrightOn", "BIT", false),
        recommend("recommend", "recommend", "BIT", false),
        commentOn("comment_on", "commentOn", "BIT", false),
        realeased("realeased", "realeased", "BIT", false),
        isDeleted("is_deleted", "isDeleted", "BIT", false),
        gmtCreated("gmt_created", "gmtCreated", "TIMESTAMP", false),
        gmtModified("gmt_modified", "gmtModified", "TIMESTAMP", false),
        content("content", "content", "LONGVARCHAR", false);

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