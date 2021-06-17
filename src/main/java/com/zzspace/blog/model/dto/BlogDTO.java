package com.zzspace.blog.model.dto;

import com.zzspace.blog.common.anno.DateFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 76973 on 2021/6/6 8:31
 */
public class BlogDTO implements Serializable {
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

    private Integer typeId;

    private TypeDTO type;

    /**
     * user_id (10)必填<br>
     *用户
     */
    private Integer userId;

    private String username;

    /**
     * content (255)<br>
     *内容
     */
    private String content;

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
     * view (10)<br>
     *阅读量
     */
    private Integer view;

    /**
     * appreciation_on (1)默认值 [b'1']<br>
     *赞赏是否开启
     */
    private boolean appreciationOn;

    /**
     * copyright_on (1)默认值 [b'1']<br>
     *版权是否开启
     */
    private boolean copyrightOn;

    /**
     * recommend (1)默认值 [b'1']<br>
     *是否推荐
     */
    private boolean recommend;

    /**
     * comment_on (1)默认值 [b'1']<br>
     *评论是否开启
     */
    private boolean commentOn;

    /**
     * realeased (1)<br>
     *是否发布
     */
    private boolean realeased;

    /**
     * is_deleted (1)必填<br>
     *是否逻辑删除
     */
    private boolean isDeleted;

    /**
     * gmt_created (19)<br>
     *创建时间
     */
    @DateFormat
    private String gmtCreated;

    /**
     * gmt_modified (19)<br>
     *更新时间
     */
    @DateFormat
    private String gmtModified;

    public BlogDTO() {
//        this.type = new TypeDTO();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public boolean getAppreciationOn() {
        return appreciationOn;
    }

    public void setAppreciationOn(boolean appreciationOn) {
        this.appreciationOn = appreciationOn;
    }

    public boolean getCopyrightOn() {
        return copyrightOn;
    }

    public void setCopyrightOn(boolean copyrightOn) {
        this.copyrightOn = copyrightOn;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean getCommentOn() {
        return commentOn;
    }

    public void setCommentOn(boolean commentOn) {
        this.commentOn = commentOn;
    }

    public boolean getRealeased() {
        return realeased;
    }

    public void setRealeased(boolean realeased) {
        this.realeased = realeased;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
