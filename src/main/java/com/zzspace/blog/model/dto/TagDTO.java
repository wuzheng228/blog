package com.zzspace.blog.model.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by 76973 on 2021/6/18 11:57
 */
public class TagDTO implements Serializable, Comparable<TagDTO>{

    private Long id;
    @NotBlank(message = "标签名不能为空")
    private String name;
    private String ids;
    private Long total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public int compareTo(TagDTO o) {
        return Long.compare(this.total, o.total);
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
