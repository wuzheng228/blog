package com.zzspace.blog.web.admin;

import com.alibaba.fastjson.JSONObject;
import com.zzspace.blog.common.util.DiskUtils;
import com.zzspace.blog.model.dto.CrumbDTO;
import com.zzspace.blog.model.dto.FileDTO;
import com.zzspace.blog.model.dto.Result;
import com.zzspace.blog.model.entity.MultiFile;
import com.zzspace.blog.service.DiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 76973 on 2021/6/30 21:49
 */
@Controller
@RequestMapping("/admin/disk")
public class DiskController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DiskService diskService;

    @GetMapping
    public String toDiskPage(Long id, Model model) {
        if(id == null)
            id = -1L;
        Long num = diskService.countFilesByParentId(id);
        List<CrumbDTO> crumbs = diskService.listCrumbs(id);
        List<FileDTO> fileDTOS = diskService.listFileByParentId(id);
        model.addAttribute("fileNum", num);
        model.addAttribute("crumbs", crumbs);
        model.addAttribute("files", fileDTOS);
        return "admin/disk";
    }

    @ResponseBody
    @PostMapping("/upload")
    public Result<String> upload(Long id, MultiFile multiFile) {
        if(id == null)
            id = -1L;
        try {
            String msg = diskService.upload(multiFile, id);
            return Result.success(msg);
        } catch (Exception e) {
            log.info("文件上传失败 parentid: {}", id, e);
        }
        return Result.failed();
    }

    @ResponseBody
    @PostMapping("/download")
    public Result<String> downloadById(Long id, HttpServletResponse resp) {
        System.out.println(id);
        try {
            diskService.downloadById(id, resp);
            return Result.success();
        } catch (Exception e) {
            log.info("文件下载失败! ",e);
        }
        return Result.failed();
    }

    @ResponseBody
    @PostMapping("/delete")
    public Result<String> deleteFileById(Long id) {
        try {
            diskService.deleteFileById(id);
            return Result.success();
        } catch (Exception e) {
            log.info("删除失败", e);
        }
        return Result.failed();
    }

    @ResponseBody
    @PostMapping("/rename")
    public Result<String> renameFileById(Long id, String name) {
        try {
            boolean res = diskService.isComplictName(id, name);
            if (res) {
                return Result.failed("文件名重复");
            }
            diskService.renameFileById(id, name);
            return Result.success();
        } catch (Exception e) {
            log.info("修改文件名失败", e);
        }
        return Result.failed();
    }

    @PostMapping("/mkdirs")
    public String mkdir(CrumbDTO crumbDTO, Model model, RedirectAttributes attributes) {
        boolean res = diskService.mkdir(crumbDTO);
        attributes.addAttribute("id", crumbDTO.getParentId());
        if (!res) {
            attributes.addFlashAttribute("message", "已存在该文件夹不能重复创建");
        }
        return "redirect:/admin/disk";
    }

    @PostMapping("/listAllFile")
    public String listAllFile(Long parentId, Model model) {
        List<CrumbDTO> crumbs = diskService.listCrumbs(parentId);
        List<FileDTO> fileDTOS = diskService.listFileByParentId(parentId);
        Long num = diskService.countFilesByParentId(parentId);
        model.addAttribute("fileNum", num);
        model.addAttribute("crumbs", crumbs);
        model.addAttribute("files", fileDTOS);
        return "admin/disk :: list";
    }
}
