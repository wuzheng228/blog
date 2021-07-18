package com.zzspace.blog.model.dto;

import com.zzspace.blog.common.anno.DateFormat;
import com.zzspace.blog.common.enums.DatePatternEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 76973 on 2021/7/10 10:29
 */
public class ArchiveDTO implements Serializable {

    private Long totalBlog;
    private Map<String, PageDTO<Item>> archives;

    public Long getTotalBlog() {
        return totalBlog;
    }

    public void setTotalBlog(Long totalBlog) {
        this.totalBlog = totalBlog;
    }

    public Map<String, PageDTO<Item>> getArchives() {
        return archives;
    }

    public void setArchives(Map<String, PageDTO<Item>> archives) {
        this.archives = archives;
    }

    public static class Item {
        private Long id;
        private String title;
        @DateFormat(pattern = "MM月dd日")
        private String gmtCreated;
        private String flag;

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

        public String getGmtCreated() {
            return gmtCreated;
        }

        public void setGmtCreated(String gmtCreated) {
            this.gmtCreated = gmtCreated;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}
