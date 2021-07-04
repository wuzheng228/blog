package com.zzspace.blog.common.util;

import com.zzspace.blog.model.entity.MultiFile;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by 76973 on 2021/7/1 21:23
 */
public class DiskUtils {

    private final static Logger log = LoggerFactory.getLogger(DiskUtils.class);

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

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "_");
    }

    /**
     * 创建文件夹
     */
    public static void mkdirs(String path) {
        File tagetDir = new File(path);
        if (!tagetDir.exists()) {
            tagetDir.mkdirs();
        }
    }

    /**
     * 按系统分割符拼接路径
     */
    public static String contacSeperator(String path, String name) {
        if (path.endsWith("\\") || path.endsWith("/")) {
            return path + name;
        }
        return path + File.separator + name;
    }

    /**
     * 判断文件是否是图片
     */
    public static boolean isImage(String path) {
        String[] strs = path.split("\\.");
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
     * 载保存时中文文件名的字符编码转换方法
     */
    public static String toUTF8String(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            // 取出字符中的每个字符
            char c = str.charAt(i);
            // Unicode码值为0~255时，不做处理
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else { // 转换 UTF-8 编码
                byte[] b;
                b = Character.toString(c).getBytes(StandardCharsets.UTF_8);
                // 转换为%HH的字符串形式
                for (int value : b) {
                    int k = value;
                    if (k < 0) {
                        k &= 255;
                    }
                    sb.append("%").append(Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    /**
     * 递归删除文件
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files) {
                deleteFile(subFile.getPath());
            }
        }
        return file.delete();
    }

    /**
     * 文件重命名
     */
    public static String renameFile(String path, String name) {
        File file = new File(path);
        File taget = new File(contacSeperator(file.getParent(), name));
        file.renameTo(taget);
        return taget.getPath();
    }

    public static String parseFileName(String path) {
        File file = new File(path);
        return file.getName();
    }
}
