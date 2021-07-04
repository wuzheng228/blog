package com.zzspace.blog.common.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by 76973 on 2021/7/4 19:38
 */
public class DiskUtilsTest {
    @Test
    public void test() throws IOException {
        File file = new File("D:\\upload");
//        DiskUtils.deleteFile("D:\\upload");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }
}
