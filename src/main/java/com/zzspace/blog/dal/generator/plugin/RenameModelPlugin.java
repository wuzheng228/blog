package com.zzspace.blog.dal.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.*;

public class RenameModelPlugin extends PluginAdapter {

    private String prefix2Remove;

    private String suffix2Append;

    @Override
    public boolean validate(List<String> warnings) {
        prefix2Remove = properties.getProperty("prefix2Remove");
        suffix2Append = properties.getProperty("suffix2Append");
        return !prefix2Remove.isEmpty() || suffix2Append != null;
    }


    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        System.out.println(introspectedTable.getBaseRecordType());
        introspectedTable.setExampleType(rename(introspectedTable.getExampleType(), false));
        introspectedTable.setMyBatis3JavaMapperType(rename(introspectedTable.getMyBatis3JavaMapperType(), false));
        introspectedTable.setMyBatis3SqlProviderType(rename(introspectedTable.getMyBatis3SqlProviderType(), false));
        introspectedTable.setBaseRecordType(rename(introspectedTable.getBaseRecordType(),true));
    }

    private String rename(String origin, boolean applyAppend) {
        int startIndex = origin.lastIndexOf('.');
        String className = origin.substring(startIndex + 1);
        StringBuilder sb = new StringBuilder(className);
        if (className.toLowerCase().startsWith(prefix2Remove)) {
            sb.delete(0, prefix2Remove.length());
            sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
        }
        if (applyAppend && suffix2Append != null) {
            sb.append(suffix2Append);
        }
        String newClassName = sb.toString();
        sb = new StringBuilder(origin);
        sb.setLength(startIndex + 1);
        sb.append(newClassName);
        return sb.toString();
    }


}
