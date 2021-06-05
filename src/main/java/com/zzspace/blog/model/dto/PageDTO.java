package com.zzspace.blog.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 76973 on 2021/5/24 20:18
 */
public class PageDTO<T> implements Serializable {

    private final static int DEFAULT_START_PAGE = 1;
    private final static int DEFAULT_PAGE_SIZE = 4;
    private final static int DEFAULT_NAV_COUNT = 2;

    private Integer curpage = DEFAULT_START_PAGE;
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    private Integer navCount = DEFAULT_NAV_COUNT;
    private int total;

    private int nextPage;
    private int prevPage;
    private int pageCount;

    private int firstPage;
    private int lastPage;

    private int startNav;
    private int endNav;

    private List<T> pageData;

    public PageDTO(Integer curpage, Integer pageSize, Integer navCount, int total) {
        if (curpage != null) {
            this.curpage = curpage;
        }
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
        if (navCount != null) {
            this.navCount = navCount;
        }
        this.total = total;

        this.pageCount = (int) Math.ceil(this.total / (this.pageSize * 1.0));
        this.firstPage = 1;
        this.lastPage = this.pageCount;

        this.curpage = Math.max(this.curpage, this.firstPage);
        this.curpage = Math.min(this.curpage, this.lastPage);

        this.prevPage = Math.max(this.curpage - 1, this.firstPage);
        this.nextPage = Math.min(this.curpage + 1, this.lastPage);

        // 计算起始导航数字和结束导航数字: 始终保证this.endNav - this.startNav = this.navCount - 1;
        this.startNav = Math.max((this.curpage - this.navCount / 2), this.firstPage);
        this.endNav = Math.min((this.startNav + this.navCount - 1), this.lastPage);
        if (this.pageCount > this.navCount) {
            this.startNav = this.endNav - this.startNav < this.navCount - 1 ? this.endNav - this.navCount + 1 : this.startNav;
        }
    }

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNavCount() {
        return navCount;
    }

    public void setNavCount(int navCount) {
        this.navCount = navCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getStartNav() {
        return startNav;
    }

    public void setStartNav(int startNav) {
        this.startNav = startNav;
    }

    public int getEndNav() {
        return endNav;
    }

    public void setEndNav(int endNav) {
        this.endNav = endNav;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public static void main(String[] args) {
        PageDTO pu = new PageDTO(8, 10, 2, 89);
        System.out.println("总页数：" + pu.getPageCount());
        System.out.println("上一页：" + pu.getPrevPage());
        System.out.println("下一页：" + pu.getNextPage());
        System.out.println("起始导航数字：" + pu.getStartNav());
        System.out.println("结束导航数字：" + pu.getEndNav());
    }
}
