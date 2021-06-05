package com.zzspace.blog.dal.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

public class CustomCriteriaPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        InnerClass criteria = null;
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
            if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) {
                criteria = innerClass;
                break;
            }
        }
        if (criteria == null) {
            // can't find the inner class for some reason, bail out.
            return true;
        }

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "criteria"));
        method.setName("andCustomCriterion");
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());

        StringBuilder sb = new StringBuilder();
        sb.append("addCriterion(");
        sb.append("criteria");
        sb.append(");");
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (Criteria) this;");

        criteria.addMethod(method);
        return true;
    }
}
