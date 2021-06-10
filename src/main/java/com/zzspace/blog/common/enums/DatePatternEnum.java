package com.zzspace.blog.common.enums;

/**
 * Created by 76973 on 2021/6/6 18:55
 */
public enum DatePatternEnum {
    yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss","年-月-日 时:分:秒");

    DatePatternEnum(String pattern, String des) {
        this.pattern = pattern;
        this.des = des;
    }

    private String pattern;
    private String des;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
