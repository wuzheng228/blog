package com.zzspace.blog.common.util;

import com.zzspace.blog.common.anno.DateFormat;
import com.zzspace.blog.common.enums.DatePatternEnum;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 76973 on 2021/6/6 18:41
 */
public class DateUtils {

    public static String formatDateToString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
