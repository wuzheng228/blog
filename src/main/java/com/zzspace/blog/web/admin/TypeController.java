package com.zzspace.blog.web.admin;

import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TypeDTO;
import com.zzspace.blog.model.query.Pageable;
import com.zzspace.blog.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by 76973 on 2021/5/25 21:50
 */
@Controller
@RequestMapping("/admin/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping()
    public String list(Pageable query, Model model) {
        PageDTO<TypeDTO> pageDTO = typeService.listType(query);
        model.addAttribute("page", pageDTO);
        return "admin/type";
    }

    @GetMapping("/input")
    public String toInputPage() {
        return "admin/type-input";
    }

    @GetMapping("/update/{id}")
    public String toUpdatePage(@PathVariable("id") int id, Model model,@RequestParam("origin") String origin,
                         @RequestParam Integer start, @RequestParam Integer pageSize) {
        model.addAttribute("id", id);
        model.addAttribute("origin", origin);
        model.addAttribute("start", start);
        model.addAttribute("pageSize", pageSize);
        return "admin/type-input";
    }

    @PostMapping("/insert")
    public String insertType(@Valid TypeDTO type, BindingResult result, RedirectAttributes attributes, Model model) {
        TypeDTO record = typeService.findTypeByName(type.getName());
        if (record != null) {
            model.addAttribute("error","分类名称已存在，请勿重复添加！");
            return "admin/type-input";
        }
        if (result.hasErrors()) {
            FieldError firstError = result.getFieldError();
            model.addAttribute("error", firstError.getDefaultMessage());
            return "admin/type-input";
        }
        TypeDTO typeDTO = typeService.insertType(type);
        if (typeDTO != null) {
            attributes.addFlashAttribute("message", "操作成功");
        } else {
            attributes.addFlashAttribute("message", "操作失败");
        }
        return "redirect:/admin/type";
    }

    @PostMapping("/update/{id}")
    public String updateType(@Valid TypeDTO type, BindingResult result,
                             @PathVariable("id") int id, RedirectAttributes attributes, Model model,
                             @RequestParam Integer start, @RequestParam Integer pageSize) {
        TypeDTO record = typeService.findTypeByName(type.getName());
        if (record != null) {
            model.addAttribute("error","已有改分类，请勿多次添加");
            return "admin/type-input";
        }
        if (result.hasErrors()) {
            FieldError firstError = result.getFieldError();
            model.addAttribute("error", firstError.getDefaultMessage());
            return "admin/type-input";
        }
        int i = typeService.upateTypeById(id, type);
        if (i != 0) {
            attributes.addFlashAttribute("message", "操作成功");
        } else {
            attributes.addFlashAttribute("message", "操作失败");
        }
        return "redirect:/admin/type?start="+start+"&pageSize=" + pageSize;
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable("id") int id, RedirectAttributes attributes,
                             @RequestParam Integer start, @RequestParam Integer pageSize) {
        boolean i = typeService.deleteById(id);
        if (i) {
            attributes.addFlashAttribute("message","删除成功！");
        } else {
            attributes.addFlashAttribute("message","删除失败！");
        }
        return "redirect:/admin/type?start="+start+"&pageSize=" + pageSize;
    }

}
