package com.zzspace.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 76973 on 2021/5/23 10:05
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blog")
    public String blog () {
        return "admin/blog";
    }
}
