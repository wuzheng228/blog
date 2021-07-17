package com.zzspace.blog.web;


import com.zzspace.blog.config.properties.BizProperties;
import com.zzspace.blog.model.dto.*;
import com.zzspace.blog.model.query.ArchiveQuery;
import com.zzspace.blog.model.query.BlogQuery;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.service.BlogService;
import com.zzspace.blog.service.TagService;
import com.zzspace.blog.service.TypeService;
import com.zzspace.blog.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
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
    @Resource
    private TagService tagService;

    @GetMapping("/")
    public String index(Pageable pageable, Model model) {
        PageDTO<BlogDTO> indexInfo = blogService.queryIndexInfo(pageable);
        List<TypeDTO> topKType = typeService.findTopKType(bizProperties.getTopk());
        List<BlogDTO> topKBlog = blogService.findTopKRecommend(bizProperties.getTopk());
        List<TagDTO> topKTag = tagService.findTopKTags(bizProperties.getTopk());
        model.addAttribute("indexInfo",indexInfo);
        model.addAttribute("types", topKType);
        model.addAttribute("topKBlog",topKBlog);
        model.addAttribute("topKTag", topKTag);
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
        blogService.incrViewByBlogId(id);
        BlogDTO blogById = blogService.findBlogById(id, true);
        UserDTO userById = userService.findUserById(blogById.getUserId());
        List<TagDTO> tagDTOS = blogService.listTagByBlogId(id);
        model.addAttribute("tags", tagDTOS);
        model.addAttribute("content", blogById);
        model.addAttribute("user", userById);
        return "blog";
    }

    @GetMapping("/index/type")
    public String showTypes(BlogQuery blogQuery, Model model) {
        List<TypeDTO> types = typeService.findTopKType(null);
        PageDTO<BlogDTO> page = blogService.listBlogByType(blogQuery);
        model.addAttribute("selectedType", blogQuery.getTypeId());
        model.addAttribute("types", types);
        model.addAttribute("page", page);
        return "types";
    }

    @GetMapping("/index/tag")
    public String showTags(BlogQuery blogQuery, Model model) {
        List<TagDTO> tags = tagService.findTopKTags(null);
        PageDTO<BlogDTO> page = blogService.listBlogByTag(blogQuery);
        model.addAttribute("selectedTag", blogQuery.getTagId());
        model.addAttribute("tags", tags);
        model.addAttribute("page", page);
        return "tags";
    }

    @GetMapping("/index/archives")
    public String showArchives(Pageable pageable, Model model) {
        ArchiveDTO archiveDTO = blogService.generateArchive(pageable);
        model.addAttribute("archives", archiveDTO);
        return "archives";
    }

    @PostMapping("/index/archives")
    public String archivesPage(ArchiveQuery archiveQuery, Model model) {
        PageDTO<ArchiveDTO.Item> page = blogService.queryArchive(archiveQuery);
        model.addAttribute("page", page);
        return "archives :: list";
    }

    @GetMapping("/index/about")
    public String toAboutPage() {
        return "about";
    }
}
