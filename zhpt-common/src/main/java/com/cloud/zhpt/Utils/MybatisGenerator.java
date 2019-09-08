package com.cloud.zhpt.Utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        //是否覆盖已存在的文件
        boolean overwrite = false;

        File configFile = new File(MybatisGenerator.class.getClassLoader().getResource("./generatorConfig.xml").getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
//        CommentGeneratorConfiguration commentGeneratorCfg = new CommentGeneratorConfiguration();
//        commentGeneratorCfg.setConfigurationType("com.cloud.zhpt.warper.SimpleCommentGenerator");
//        config.getContext("DB2Tables").setCommentGeneratorConfiguration(commentGeneratorCfg);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }

}
