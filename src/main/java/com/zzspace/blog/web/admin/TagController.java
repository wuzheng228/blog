package com.zzspace.blog.web.admin;

import com.zzspace.blog.model.dto.TagDTO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by 76973 on 2021/6/17 21:55
 */
@Controller
@RequestMapping("/admin/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping
    public String listPageTag(Pageable pageable, Model model) {
        PageDTO<TagDTO> listPageDTO = tagService.listTag(pageable);
        model.addAttribute("page", listPageDTO);
        return "admin/tag";
    }

    @GetMapping("/input")
    public String input() {
        return "admin/tag-input";
    }

    @PostMapping("/insert")
    public String insert(@Valid TagDTO tagDTO, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error",result.getFieldError().getDefaultMessage());
            return "admin/tag-input";
        }
        TagDTO tagByName = tagService.findTagByName(tagDTO);
        if (tagByName != null) {
            model.addAttribute("error","标签名称已存在，请勿重复添加！");
            return "admin/tag-input";
        }
        Long res = tagService.insertTag(tagDTO);
        if (res != null) {
            attributes.addFlashAttribute("message","插入成功");
        } else {
            attributes.addFlashAttribute("message", "插入失败");
        }
        return "redirect:/admin/tag";
    }

    @GetMapping("/update")
    public String update(@Valid TagDTO tag, @RequestParam("pageNo") Long pageNo, Model model) {
        model.addAttribute("tag", tag);
        model.addAttribute("pageNo", pageNo);
        return "admin/tag-input";
    }

    @PostMapping("/update")
    public String update(TagDTO tag, BindingResult result,@RequestParam("pageNo") Integer pageNo,RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error",result.getFieldError().getDefaultMessage());
            return "admin/tag-input";
        }
        TagDTO tagByName = tagService.findTagByName(tag);
        if (tagByName != null) {
            model.addAttribute("error","标签名称已存在，请勿重复添加！");
            return "admin/tag-input";
        }
        Integer res = tagService.updateTagById(tag);
        if (res > 0) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message","更新失败");
        }
        attributes.addAttribute("pageNo", pageNo);
        return "redirect:/admin/tag";
    }

    @GetMapping("/delete/{id}")
    public String deleteTag(@PathVariable("id") Long id, RedirectAttributes attributes) {
        Integer res = tagService.deleteTagById(id);
        if (res > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/tag";
    }

}
