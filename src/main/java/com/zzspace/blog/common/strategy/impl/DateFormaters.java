package com.zzspace.blog.common.strategy.impl;

import com.zzspace.blog.common.strategy.DateFormater;
import com.zzspace.blog.common.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 76973 on 2021/6/12 19:19
 */
public enum DateFormaters implements DateFormater {

    yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss") {
        @Override
        public String parse(Date date) {
            return DateUtils.formatDateToString(date, getPattern());
        }
    },
    yyyy_MM_dd("yyyy-MM-dd") {
        @Override
        public String parse(Date date) {
            return DateUtils.formatDateToString(date, getPattern());
        }
    };

    private String pattern;

    DateFormaters(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
