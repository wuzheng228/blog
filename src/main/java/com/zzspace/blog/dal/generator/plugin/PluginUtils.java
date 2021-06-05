package com.zzspace.blog.dal.generator.plugin;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianmin
 * @date 2020/4/1 19:34
 */
public class PluginUtils {


    /**
     * 将字符串以分隔符分隔成Set
     *
     * @param source
     * @param separator
     * @return
     */
    public static Set<String> splitToSet(String source, String separator) {
        Set<String> result = new HashSet<String>();
        if (StringUtils.isNotBlank(source)) {
            String[] splits = source.split(separator);
            for (String split : splits) {
                String trimmed = split.trim();
                if (trimmed.length() > 0) {
                    result.add(trimmed);
                }
            }
        }
        return result;
    }

}
