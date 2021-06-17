package com.zzspace.blog.web;


import com.zzspace.blog.config.properties.BizProperties;
import com.zzspace.blog.model.dto.BlogDTO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TypeDTO;
import com.zzspace.blog.model.dto.UserDTO;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.service.BlogService;
import com.zzspace.blog.service.TypeService;
import com.zzspace.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private BizProperties bizProperties;
    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;
    @Resource
    private UserService userService;

    @GetMapping("/")
    public String index(Pageable pageable, Model model) {
        PageDTO<BlogDTO> indexInfo = blogService.queryIndexInfo(pageable);
        List<TypeDTO> topKType = typeService.findTopKType(bizProperties.getTopk());
        List<BlogDTO> topKBlog = blogService.findTopKRecommend(bizProperties.getTopk());
        model.addAttribute("indexInfo",indexInfo);
        model.addAttribute("types", topKType);
        model.addAttribute("topKBlog",topKBlog);
        return "index";
    }

    @GetMapping("/index/search")
    public String search(@RequestParam("query") String query, Pageable pageable, Model model) {
        PageDTO<BlogDTO> pageDTO = blogService.listBlogByLike(query, pageable);
        model.addAttribute("pages", pageDTO);
        return "search";
    }

    @GetMapping("/index/show/{id}")
    public String showBlog(@PathVariable("id") Long id, Model model) {
        BlogDTO blogById = blogService.findBlogById(id, true);
        UserDTO userById = userService.findUserById(blogById.getUserId());
        model.addAttribute("content", blogById);
        model.addAttribute("user", userById);
        return "blog";
    }

}
