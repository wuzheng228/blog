package com.zzspace.blog.dal.generator.plugin;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.w3c.dom.Attr;

import java.util.*;

public class AutoCreateUpdateTimePlugin extends PluginAdapter {
    // 插入时间 列名
    private Set<String> insertTimeColumnNames;
    // 更新时间 列名
    private Set<String> lastUpdateTimeColumnNames;
    // 数据库获取当前时间的函数表达式
    private String dbCurrentTimeExpr;
    @Override
    public boolean validate(List<String> warnings) {
        insertTimeColumnNames = new HashSet<>(Arrays.asList(properties.getProperty("insertTimeColumns").split(",")));
        lastUpdateTimeColumnNames = new HashSet<>(Arrays.asList(properties.getProperty("lastUpdateTimeColumns").split(",")));
        dbCurrentTimeExpr = properties.getProperty("dbCurrentTimeExpr");
        return true;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        System.out.println("sqlMapInsertElementGenerated started");
        int i = 0;
        for (Element child : element.getElements()) {
            if (child instanceof TextElement) {
                String content = ((TextElement) child).getContent();
                for (String insertTimeJavaProperty : getInsertTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{" + insertTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                for (String updateTimeJavaProperty : getUpdateTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{" + updateTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                element.getElements().set(i, new TextElement(content));
            }
            i++;
        }
        return true;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        int i = 0;
        for (Element child : element.getElements()) {
            if (child instanceof XmlElement) {
                XmlElement xe = (XmlElement) child;
                int j = 0;
                for (Attribute attribute : xe.getAttributes()) {
                    String value = attribute.getValue();
                    // <if test="gmtCreated != null"> ---> <if test=true>
                    for (String insertTimeJavaProperty : getInsertTimeJavaProperties(introspectedTable)) {
                        value = value.replaceAll(insertTimeJavaProperty + " != null", "true");
                    }
                    for (String updateTimeJavaProperty : getUpdateTimeJavaProperties(introspectedTable)) {
                        value = value.replaceAll(updateTimeJavaProperty + " != null","true");
                    }
                    xe.getAttributes().set(j, new Attribute(attribute.getName(),value));
                    j++;
                }
                // 递归到下一层
                sqlMapInsertSelectiveElementGenerated(xe, introspectedTable);
            } else {
                TextElement old = (TextElement) child;
                String content = old.getContent();
                for (String insertTimeJavaProperty : getInsertTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{" + insertTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                for (String updateTimeJavaProperty : getUpdateTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{" + updateTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                element.getElements().set(i, new TextElement(content));
            }
            i++;
        }
        return true;
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        int i = 0;
        for (Element child : element.getElements()) {
            if (child instanceof TextElement) {
                String content = ((TextElement) child).getContent();
                for (String insertTimeJavaProperty : getInsertTimeJavaProperties(introspectedTable)) {
                    if (content.contains(insertTimeJavaProperty)) { // 不需要更新插入时间
                        content = "";
                    }
                }
                for (String updateTimeJavaProperty : getUpdateTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{[^\\{]*" + updateTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                element.getElements().set(i, new TextElement(content));
            }
            i++;
        }
        return true;
    }

    @Override
    public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        int i = 0;
        for (Element child : element.getElements()) {
            if (child instanceof XmlElement) {
                List<Attribute> attrs = ((XmlElement) child).getAttributes();
                int j = 0; // 属性下标
                for (Attribute attr : attrs) {
                    String value = attr.getValue();
                    for (String insertTimeJavaProperty : getInsertTimeJavaProperties(introspectedTable)) {
                        value = value.replaceAll("record." + insertTimeJavaProperty + " != null", "false"); // byExampleSelective
                        value = value.replaceAll(insertTimeJavaProperty + " != null", "false");
                    }
                    for (String updateTimeJavaProperty : getUpdateTimeJavaProperties(introspectedTable)) {
                        value = value.replaceAll("record." + updateTimeJavaProperty + " != null", "true");
                        value = value.replaceAll(updateTimeJavaProperty + " != null", "true");
                    }
                    ((XmlElement) child).getAttributes().set(j, new Attribute(attr.getName(),value));
                    j++;
                }
                // 递归
                sqlMapUpdateByPrimaryKeySelectiveElementGenerated((XmlElement) child, introspectedTable);
            } else {
                String content = ((TextElement) child).getContent();
                for (String insertTimeJavaProperty : getInsertTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{[^\\{]*" + insertTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                for (String updateTimeJavaProperty : getUpdateTimeJavaProperties(introspectedTable)) {
                    content = content.replaceAll("#\\{[^\\{]*" + updateTimeJavaProperty + "[^\\{]*\\}", dbCurrentTimeExpr);
                }
                ((XmlElement) element).getElements().set(i, new TextElement(content));
            }
            i++;
        }
        return true;
    }

    @Override
    public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    private Set<String> getInsertTimeJavaProperties(IntrospectedTable introspectedTable) {
        return getMatchedProperties(introspectedTable, insertTimeColumnNames);
    }

    private Set<String> getUpdateTimeJavaProperties(IntrospectedTable introspectedTable) {
        return getMatchedProperties(introspectedTable, lastUpdateTimeColumnNames);
    }

    private Set<String> getMatchedProperties(IntrospectedTable introspectedTable, Set<String> names) {
        Set<String> result = new HashSet<>();
        for (String name : names) {
            IntrospectedColumn column = introspectedTable.getColumn(name);
            if (column != null) {
                result.add(column.getJavaProperty());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("#{inserttime,jdbcType=TIMESTAMP},#{ }".replaceAll(
                "#\\{inserttime[^\\{]*\\}", "getdate()"));
        System.out.println("#{record.gmtCreated,jdbcType=TIMESTAMP},#{ }".replaceAll(
                "#\\{[^\\{]*gmtCreated[^\\{]*\\}", "getdate()"));
        System.out.println("addTime != null".replaceAll(
                "addTime != null", "true"));
        System.out.println("record.addTime != null".replaceAll(
                "record.addTime != null", "true"));
    }
}
