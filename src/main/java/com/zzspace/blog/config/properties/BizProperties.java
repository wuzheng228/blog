package com.zzspace.blog.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 76973 on 2021/6/13 6:16
 */
@Component
@ConfigurationProperties(prefix = "zzspace.blog")
public class BizProperties {

    @Value("${zzspace.blog.topk}")
    private int topk;
    @Value("${zzspace.blog.avatar.tourist}")
    private String touristAvatar;
    @Value("${zzspace.blog.avatar.admin}")
    private String adminAvatar;
    @Value("${zzspace.blog.imagePath}")
    private String imagePath;
    @Value("${zzspace.blog.rootFilePath}")
    private String rootFilePath;

    public int getTopk() {
        return topk;
    }

    public void setTopk(int topk) {
        this.topk = topk;
    }

    public String getTouristAvatar() {
        return touristAvatar;
    }

    public void setTouristAvatar(String touristAvatar) {
        this.touristAvatar = touristAvatar;
    }

    public String getAdminAvatar() {
        return adminAvatar;
    }

    public void setAdminAvatar(String adminAvatar) {
        this.adminAvatar = adminAvatar;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRootFilePath() {
        return rootFilePath;
    }

    public void setRootFilePath(String rootFilePath) {
        this.rootFilePath = rootFilePath;
    }
}
