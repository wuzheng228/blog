package com.zzspace.blog.dal.generator;

import org.apache.commons.io.FileUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        boolean overwrite = true;
        File configFile = new File(Main.class.getClassLoader().getResource("mybatis/generatorConfig.xml").getPath());
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        List<String> fileNames = new ArrayList<>();
        for(TableConfiguration tableConfiguration : config.getContexts().get(0).getTableConfigurations()){
            fileNames.add(tableConfiguration.getDomainObjectName()+"Mapper.xml");
        }
        cleanAutoGeneratedXmlDir(config, callback, fileNames);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("Mybatis generator runned successfully.");
        if (warnings.size() > 0) {
            System.out.println("\r\nWith warnings");
            for (String warning : warnings) {
                System.out.println(warning);
            }
        }
        System.out.println("\r\nRefresh your infrastructure project to see the latest db mode/mapper/mapperxml");
    }

    private static void cleanAutoGeneratedXmlDir(Configuration config, ShellCallback shellCallback, List<String> filenames)
            throws ShellException {
        File directory = shellCallback.getDirectory(
                config.getContexts().get(0).getSqlMapGeneratorConfiguration().getTargetProject(),
                config.getContexts().get(0).getSqlMapGeneratorConfiguration().getTargetPackage());

        if (filenames.size() > 0){
            String directoryPath = directory.getPath()+File.separatorChar;
            for(String str:filenames){
                String filePath = directoryPath + str;
                FileUtils.deleteQuietly(new File(filePath));
            }
        }
    }
}
