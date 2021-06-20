package com.zzspace.blog.model.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by 76973 on 2021/6/18 11:57
 */
public class TagDTO implements Serializable {

    private Long id;
    @NotBlank(message = "标签名不能为空")
    private String name;
    private String ids;

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

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
