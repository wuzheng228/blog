package com.zzspace.blog.common.util;

import com.zzspace.blog.model.entity.MultiFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 76973 on 2021/7/1 21:23
 */
public class UploadUtils {

    private final static Logger log = LoggerFactory.getLogger(UploadUtils.class);

    public static String uploadFile(MultipartFile file, String path) {
        mkdirs(path);
        File targetFile = new File(path, getRandomUUID() + "_" + file.getOriginalFilename());
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            log.info("上传文件失败", e);
        }
        return targetFile.getPath();
    }
    /**
     * 上传多个文件
     */
    public static List<String> uploadFiles(MultiFile multiFile, String path) {
        List<String> paths = new ArrayList<>();
        mkdirs(path);
        List<MultipartFile> files = multiFile.getFiles();
        files.forEach(file -> {
            File tagetFile = new File(path, getRandomUUID() + "_" + file.getOriginalFilename());
            try {
                file.transferTo(tagetFile);
                paths.add(tagetFile.getPath());
            } catch (IOException e) {
                log.info("上传文件保存失败！",e);
            }
        });
        return paths;
    }

    private static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "_");
    }

    public static void mkdirs(String path) {
        File tagetDir = new File(path);
        if (!tagetDir.exists()) {
            tagetDir.mkdirs();
        }
    }

    public static String contacSeperator(String path, String name) {
        if (path.endsWith("\\") || path.endsWith("/")) {
            return path + name;
        }
        return path + File.separator + name;
    }
}
