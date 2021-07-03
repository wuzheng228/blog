package com.zzspace.blog.service;

import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.common.util.UploadUtils;
import com.zzspace.blog.config.properties.BizProperties;
import com.zzspace.blog.dal.domain.FileDO;
import com.zzspace.blog.dal.domain.PathDO;
import com.zzspace.blog.dal.repository.FileRepository;
import com.zzspace.blog.dal.repository.PathRepository;
import com.zzspace.blog.model.dto.CrumbDTO;
import com.zzspace.blog.model.dto.FileDTO;
import com.zzspace.blog.model.entity.MultiFile;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/7/1 20:50
 */
@Service
public class DiskService {

    @Resource
    private BizProperties bizProperties;
    @Resource
    private FileRepository fileRepository;
    @Resource
    private PathRepository pathRepository;

    /**
     * 根据parent_id列出所有文件
     */
    public List<FileDTO> listFileByParentId(Long id) {
        List<FileDO> fileDOS = fileRepository.listFileByParentId(id);
        List<FileDTO> fileDTOS = ConvertUtils.convertList(fileDOS, FileDTO.class);
        return fileDTOS;
    }

    /**
     * 上传文件
     */
    public String upload(MultiFile multiFile, Long id) {
        PathDO pathDO = pathRepository.findPathByParentId(id);
        List<MultipartFile> files = multiFile.getFiles();
        files.forEach(file -> {
            String path = null;
            if (pathDO == null) {
                path = bizProperties.getRootFilePath();
            } else {
                path = pathDO.getPath();
            }
            String tagetFilePath = UploadUtils.uploadFile(file, path);
            FileDO fileDO = new FileDO();
            fileDO.setDir(false);
            fileDO.setName(file.getOriginalFilename());
            fileDO.setType(file.getContentType());
            fileDO.setPath(tagetFilePath);
            fileRepository.save(fileDO);
        });
        return "done";
    }

    private boolean isImage(String name) {
        String[] strs = name.split("\\.");
        String last = strs[strs.length - 1];
        if (StringUtils.endsWithIgnoreCase(last,"png")) {
            return true;
        }
        if (StringUtils.endsWithIgnoreCase(last,"jpg")) {
            return true;
        }
        return StringUtils.endsWithIgnoreCase(last, "bmp");
    }

    /**
     * 新建文件夹
     */
    public void mkdir(CrumbDTO crumbDTO) {
        PathDO record = pathRepository.findPathByParentId(crumbDTO.getParentId());
        String path;
        if (record == null) {
            path = bizProperties.getRootFilePath();
            UploadUtils.mkdirs(UploadUtils.contacSeperator(path, crumbDTO.getName()));
        } else {
            path = record.getPath();
            UploadUtils.mkdirs(UploadUtils.contacSeperator(path, crumbDTO.getName()));
        }
        upsertFileByFileNameAndParentId(crumbDTO.getName(), crumbDTO.getParentId(), record == null ? bizProperties.getRootFilePath() : record.getPath());
        upsertPathByParentId(crumbDTO.getParentId(), path);
    }

    private void upsertPathByParentId(Long parentId, String path) {
        PathDO record = pathRepository.findPathByParentId(parentId);
        if (record == null) {
            PathDO pathDO = new PathDO();
            pathDO.setPath(path);
            pathDO.setParentId(parentId);
            pathRepository.save(pathDO);
        } else {
            record.setPath(path);
            pathRepository.updateById(record);
        }
    }

    private void upsertFileByFileNameAndParentId(String name, Long parentId, String parentPath) {
        FileDO record = fileRepository.findByFileNameAndParentId(name, parentId);
        if (record == null) {
            FileDO fileDO = new FileDO();
            fileDO.setName(name);
            fileDO.setDir(true);
            fileDO.setParentId(parentId);
            fileDO.setType("folder");
            fileDO.setPath(UploadUtils.contacSeperator(parentPath, name));
            fileRepository.save(fileDO);
        } else {
            record.setName(name);
            record.setDir(true);
            record.setParentId(parentId);
            record.setType("folder");
            record.setPath(UploadUtils.contacSeperator(parentPath, name));
            fileRepository.updateById(record);
        }
    }
}
