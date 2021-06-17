package com.zzspace.blog.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 76973 on 2021/6/13 6:16
 */
@Component
@ConfigurationProperties(prefix = "zzspace.blog")
public class BizProperties {

    @Value("${zzspace.blog.topk}")
    private int topk;

    public int getTopk() {
        return topk;
    }

    public void setTopk(int topk) {
        this.topk = topk;
    }
}
