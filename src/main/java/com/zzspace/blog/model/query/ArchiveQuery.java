package com.zzspace.blog.model.query;

/**
 * Created by 76973 on 2021/7/14 16:42
 */
public class ArchiveQuery extends Pageable {
    private String index;
    private String year;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
