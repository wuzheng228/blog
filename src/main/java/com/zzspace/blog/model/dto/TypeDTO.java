package com.zzspace.blog.model.dto;

import com.zzspace.blog.dal.domain.TypeDO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by 76973 on 2021/6/5 9:00
 */
public class TypeDTO implements Serializable {
    /**
     * id (10)必填<br>
     *分类id
     */
    private Integer id;

    /**
     * name (10)<br>
     *分类名
     */
    @NotBlank(message = "请输入分类名称")
    @Size(min = 1, max = 64, message = "分类名称长度不能超过64")
    private String name;

    public TypeDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "TypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
