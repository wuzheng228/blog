package com.zzspace.blog.service;

import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.common.util.DiskUtils;
import com.zzspace.blog.config.properties.BizProperties;
import com.zzspace.blog.dal.domain.FileDO;
import com.zzspace.blog.dal.domain.PathDO;
import com.zzspace.blog.dal.repository.FileRepository;
import com.zzspace.blog.dal.repository.PathRepository;
import com.zzspace.blog.model.dto.CrumbDTO;
import com.zzspace.blog.model.dto.FileDTO;
import com.zzspace.blog.model.entity.MultiFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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
        fileDOS.sort((o1, o2) -> {
            if (o1.getDir() && !o2.getDir()) return -1;
            else if (!o1.getDir() && o2.getDir()) return 1;
            else return o1.getName().compareTo(o2.getName());
        });
        return ConvertUtils.convertList(fileDOS, FileDTO.class);
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
            String tagetFilePath = DiskUtils.uploadFile(file, path);
            FileDO fileDO = new FileDO();
            fileDO.setDir(false);
            fileDO.setName(file.getOriginalFilename());
            fileDO.setType(file.getContentType());
            fileDO.setPath(tagetFilePath);
            fileDO.setParentId(id);
            fileRepository.save(fileDO);
        });
        return "done";
    }

    /**
     * 新建文件夹
     */
    @Transactional
    public boolean mkdir(CrumbDTO crumbDTO) {
        FileDO fileDO = fileRepository.findByFileNameAndParentId(crumbDTO.getName(), crumbDTO.getParentId());
        if (fileDO != null)
            return false;
        PathDO record = pathRepository.findPathByParentId(crumbDTO.getParentId());
        String path;// 父文件夹路径
        if (record == null) { // 说明当前在根目录并没有新建过文件夹
            path = bizProperties.getRootFilePath();
            DiskUtils.mkdirs(DiskUtils.contacSeperator(path, crumbDTO.getName()));
            upsertPathByParentId(crumbDTO.getParentId(), path);
        } else {
            path = record.getPath();
            DiskUtils.mkdirs(DiskUtils.contacSeperator(path, crumbDTO.getName()));
        }
        upsertFileByFileNameAndParentId(crumbDTO.getName(), crumbDTO.getParentId(), record == null ? bizProperties.getRootFilePath() : record.getPath());
        return true;
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
            fileDO.setPath(DiskUtils.contacSeperator(parentPath, name));
            fileRepository.save(fileDO);
            PathDO pathDO = new PathDO();
            pathDO.setParentId(fileDO.getId());
            pathDO.setPath(DiskUtils.contacSeperator(parentPath, name));
            pathRepository.save(pathDO);
        } else {
            record.setName(name);
            record.setDir(true);
            record.setParentId(parentId);
            record.setType("folder");
            record.setPath(DiskUtils.contacSeperator(parentPath, name));
            int id = fileRepository.updateById(record);
            PathDO pathDO = new PathDO();
            pathDO.setParentId((long)id);
            pathDO.setPath(DiskUtils.contacSeperator(parentPath, name));
            pathRepository.updateByParentId(pathDO);
        }
    }

    public List<CrumbDTO> listCrumbs(Long parentId) {
        List<CrumbDTO> crumbDTOS = new ArrayList<>();
        if(parentId == -1){
            return crumbDTOS;
        }
        while (true) {
            FileDO fileDO = fileRepository.findById(parentId);
            if (fileDO == null) break;
            CrumbDTO crumbDTO = new CrumbDTO();
            crumbDTO.setName(fileDO.getName());
            crumbDTO.setParentId(fileDO.getId());
            crumbDTOS.add(crumbDTO);
            parentId = fileDO.getParentId();
            if (fileDO.getParentId() == -1L) {
                break;
            }
        }
        Collections.reverse(crumbDTOS);
        return crumbDTOS;
    }

    /**
     * 下载对应的文件
     */
    public void downloadById(Long id, HttpServletResponse resp) throws Exception {
        FileDO fileDO = fileRepository.findById(id);
        resp.setHeader("Content-Type", "application/x-msdownload");
        resp.setHeader("Content-Disposition", "attachment; filename=" + DiskUtils.toUTF8String(fileDO.getName()));
        try (FileInputStream fin = new FileInputStream(fileDO.getPath()); ServletOutputStream out = resp.getOutputStream()) {
            out.flush();
            byte[] bytes = new byte[2048];
            while (fin.available() > 0) {
                fin.read(bytes);
                out.write(bytes);
            }
            out.flush();
        }
    }

    /**
     * 递归删除文件
     */
    @Transactional
    public void deleteFileById(Long id) {
        FileDO fileDO = fileRepository.findById(id);
        if (fileDO.getDir()) {
            List<FileDO> fileDOS = fileRepository.listFileByParentId(fileDO.getId());
            for (FileDO file : fileDOS) {
                deleteFileById(file.getId());
            }
            pathRepository.deleteByParentId(fileDO.getId());
            fileRepository.deleteById(id);
            DiskUtils.deleteFile(fileDO.getPath());
        } else {
            fileRepository.deleteById(id);
            DiskUtils.deleteFile(fileDO.getPath());
        }
    }

    /**
     * 文件重命名
     */
    @Transactional
    public void renameFileById(Long id, String name) {
        FileDO fileDO = fileRepository.findById(id);
        if (fileDO.getDir()) {
            String newPath = DiskUtils.renameFile(fileDO.getPath(), name);
            FileDO record = new FileDO();
            record.setId(id);
            record.setName(name);
            record.setPath(newPath);
            fileRepository.updateById(record);
            PathDO pathDO = new PathDO();
            pathDO.setPath(newPath);
            pathDO.setParentId(id);
            pathRepository.updateByParentId(pathDO);
            List<FileDO> fileDOS = fileRepository.listFileByParentId(id);
            for (FileDO file : fileDOS) {
                updateFilePath(file, newPath);
            }
        } else {
            String newfilename = name + fileDO.getPath().substring(fileDO.getPath().lastIndexOf('.'));
            String newFilePath = DiskUtils.renameFile(fileDO.getPath(),
                    DiskUtils.getRandomUUID() + "_" + newfilename);
            FileDO record = new FileDO();
            record.setId(id);
            record.setName(newfilename);
            record.setPath(newFilePath);
            fileRepository.updateById(record);
        }
    }

    private void updateFilePath(FileDO fileDO, String parentPath) {
        String fileName = DiskUtils.parseFileName(fileDO.getPath());
        if (fileDO.getDir()) {
            String newPath = DiskUtils.contacSeperator(parentPath, fileName);
            fileDO.setPath(DiskUtils.contacSeperator(parentPath, fileName));
            fileRepository.updateById(fileDO);
            PathDO pathDO = new PathDO();
            pathDO.setPath(newPath);
            pathDO.setParentId(fileDO.getId());
            pathRepository.updateByParentId(pathDO);
            List<FileDO> fileDOS = fileRepository.listFileByParentId(fileDO.getId());
            for (FileDO file : fileDOS) {
                updateFilePath(file, newPath);
            }
        } else {
            fileDO.setPath(DiskUtils.contacSeperator(parentPath, fileName));
            fileRepository.updateById(fileDO);
        }
    }

    public Long countFilesByParentId(Long id) {
        return fileRepository.countFilesByParentId(id);
    }

    public boolean isComplictName(Long id, String name) {
        FileDO fileDO = fileRepository.findById(id);
        FileDO record = fileRepository.findByFileNameAndParentId(DiskUtils.parseFileName(fileDO.getPath()), fileDO.getParentId());
        return record != null;
    }

    public String copyRealNameById(Long id) {
        FileDO fileDO = fileRepository.findById(id);
        return DiskUtils.parseFileName(fileDO.getPath());
    }
}
