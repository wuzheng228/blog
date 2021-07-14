package com.zzspace.blog.model.query;

import java.io.Serializable;

/**
 * Created by 76973 on 2021/6/6 8:44
 */
public class Pageable implements Serializable {

    private static final int DEFAULT_SATRT_ROW = 0;
    private static final int DEFAULT_PAGE_NO = 1;
    private static final int DEFAULT_PAGE_SIZE = 5;

    private int startRow = DEFAULT_SATRT_ROW;
    private int pageNo = DEFAULT_PAGE_NO;
    private int pageSize = DEFAULT_PAGE_SIZE;

    public Pageable() {
        this.startRow = (pageNo - 1) * this.pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
            this.startRow = (pageNo - 1) * this.pageSize;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
            this.startRow = (this.pageNo - 1) * this.pageSize;
        }
    }

    public int getOffset() {
        return startRow;
    }

    public int getLimit() {
        return pageSize;
    }
}
