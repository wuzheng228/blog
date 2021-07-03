package com.zzspace.blog.web.admin;

import com.alibaba.fastjson.JSONObject;
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

import javax.annotation.Resource;
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
        List<FileDTO> fileDTOS = diskService.listFileByParentId(id);
        model.addAttribute("files", fileDTOS);
        return "admin/disk";
    }

    @ResponseBody
    @PostMapping("/upload")
    public Result<String> upload(Long id, MultiFile multiFile) {
        try {
            String msg = diskService.upload(multiFile, id);
            return Result.success(msg);
        } catch (Exception e) {
            log.info("文件上传失败 parentid: {}", id, e);
        }
        return Result.failed();
    }


    @PostMapping("/mkdirs")
    public String mkdir(CrumbDTO crumbDTO, Model model) {
        diskService.mkdir(crumbDTO);
        List<FileDTO> fileDTOS = diskService.listFileByParentId(crumbDTO.getParentId());
        model.addAttribute("files", fileDTOS);
        return "admin/disk";
    }

    @PostMapping("/listAllFile")
    public String listAllFile(Long parentId, Model model) {
        System.out.println(parentId);
        List<FileDTO> fileDTOS = diskService.listFileByParentId(parentId);
        model.addAttribute("files", fileDTOS);
        return "admin/disk :: list";
    }
}
