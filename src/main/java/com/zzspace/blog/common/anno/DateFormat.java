package com.zzspace.blog.common.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 76973 on 2021/6/6 18:50
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
    String pattern() default "yyyy-MM-dd HH:mm:ss";
}
