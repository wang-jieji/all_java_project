package com.example.demo.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        String projectPath = "E:/PROJECT/all_java_project/jwt";
        //输出路径
        gc.setOutputDir(projectPath + "/src/main/java")
                // 作者
                .setAuthor("WJJ")
                //重新生成的时候是否覆盖原文件
                .setFileOverride(true)
                // 设置生成的service接口的名字的首字母是否为I
                .setServiceName("%sService")
                // 生成完成后 是否打开输出目录
                .setOpen(false)
                // 指定生成的主键的ID类型
                .setIdType(IdType.AUTO)
                //开启 ActiveRecord 模式
                .setActiveRecord(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.206.133:3306/jwt??useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDbType(DbType.MYSQL)
                // dsc.setSchemaName("public");
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("admin")
                .setPassword("123456");


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.example.demo");


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
    /*
    cfg.setFileCreate(new IFileCreate() {
        @Override
        public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
            // 判断自定义文件夹是否需要创建
            checkDir("调用默认方法创建的目录，自定义目录用");
            if (fileType == FileType.MAPPER) {
                // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                return !new File(filePath).exists();
            }
            // 允许生成模板文件
            return true;
        }
    });
    */
        cfg.setFileOutConfigList(focList);


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)   // 数据库表映射到实体的命名策略
                .setRestControllerStyle(true)
                // 公共父类
                // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
                // 写于父类中的公共字段
                //.setSuperEntityColumns("id")
                .setInclude(scanner("表名，多个英文逗号分割").split(","))
                .setControllerMappingHyphenStyle(true)
                .setTablePrefix(pc.getModuleName() + "_");

        // 整合配置

        AutoGenerator mpg = new AutoGenerator();
        // 全局
        mpg.setGlobalConfig(gc);
        // 包
        mpg.setPackageInfo(pc);
        // 数据源
        mpg.setDataSource(dsc);
        // 自定义配置
        mpg.setCfg(cfg);
        // 模板
        mpg.setTemplate(templateConfig);
        // 策略
        mpg.setStrategy(strategy);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 执行自动代码生成器
        mpg.execute();
    }

}

