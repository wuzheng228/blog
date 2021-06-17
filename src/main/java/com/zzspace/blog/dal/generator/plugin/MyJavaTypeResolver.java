package com.zzspace.blog.dal.generator.plugin;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * Created by 76973 on 2021/6/15 21:37
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public MyJavaTypeResolver() {
        super();
        super.typeMap.put(Types.LONGVARCHAR, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("longtext", new FullyQualifiedJavaType(String.class.getTypeName())));
    }

}
