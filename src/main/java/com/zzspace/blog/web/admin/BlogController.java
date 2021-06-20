package com.zzspace.blog.web.admin;

import com.zzspace.blog.common.exception.NotFoundException;
import com.zzspace.blog.model.dto.*;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.model.query.BlogQuery;
import com.zzspace.blog.service.BlogService;
import com.zzspace.blog.service.TagService;
import com.zzspace.blog.service.TypeService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 76973 on 2021/5/23 10:05
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;
    @Resource
    private TagService tagService;

    @GetMapping
    public String blog (BlogQuery blogQuery, Model model) {
        List<TypeDTO> typeDTOS = typeService.listType();
        PageDTO<BlogDTO> pageDTO = blogService.listBlog(blogQuery);
        model.addAttribute("page",pageDTO);
        model.addAttribute("types", typeDTOS);
        return "admin/blog";
    }

    @PostMapping("/search")
    public String search(BlogQuery blogQuery, Model model) {
        PageDTO<BlogDTO> pageDTO = blogService.listBlog(blogQuery);
        model.addAttribute("page", pageDTO);
        return "admin/blog :: blogList";// 只更新一个片段
    }

    @GetMapping("/input")
    public String toInputPage(@RequestParam(value = "id", required = false) Long id, Model model) {
        List<TypeDTO> typeDTOS = typeService.listType();
        List<TagDTO> tagDTOS = tagService.listTag();
        if (id != null) {
            BlogDTO blog = blogService.findBlogById(id, false);
            if (blog == null) {
                throw new NotFoundException("查无该博客");
            }
            TypeDTO type = typeService.findTypeById(blog.getTypeId());
            blog.setType(type);
            List<TagDTO> selectedTags = blogService.listTagByBlogId(id);
            List<Long> tagsIds = null;
            if (CollectionUtils.isNotEmpty(selectedTags))
              tagsIds = selectedTags.stream().map(TagDTO::getId).collect(Collectors.toList());
            model.addAttribute("tagsIds", StringUtils.join(tagsIds,","));
            model.addAttribute("selectedTags", selectedTags);
            model.addAttribute("blog",blog);
            model.addAttribute("types", typeDTOS);
            model.addAttribute("tagDTOS", tagDTOS);
            return "admin/blog-input";
        }
        model.addAttribute("types", typeDTOS);
        model.addAttribute("tagDTOS", tagDTOS);
        model.addAttribute("blog", new BlogDTO());
        return "admin/blog-input";
    }

    @PostMapping("/upsert")
    public String upsertBlog(BlogDTO blogDTO, HttpSession session, RedirectAttributes attributes) {
        UserDTO user = (UserDTO)session.getAttribute("user");
        blogDTO.setUserId(user.getId());
        int i = blogService.upsertBlog(blogDTO);
        if (i != 0) {
            attributes.addFlashAttribute("message","发布成功");
        } else {
            attributes.addFlashAttribute("message", "发布失败");
        }
        return "redirect:/admin/blog";
    }

    @GetMapping("/delete")
    public String deleteBlogById(@RequestParam long id, RedirectAttributes attributes) {
        int i = blogService.deleteBlogById(id);
        if (i > 0) {
            attributes.addFlashAttribute("message","删除成功");
        } else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/blog";
    }

}
