package com.lvgu.industrynew.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码自动生成启动类
 */
public class MyGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        // 设置数据库相关配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        autoGenerator.setDataSource(dataSourceConfig);
        // 设置全局配置
        GlobalConfig globalConfig = getGlobalConfig();
        autoGenerator.setGlobalConfig(globalConfig);
        // 数据库关键字冲突,自动处理
        // 跟包相关的配置项
        PackageConfig packageConfig = getPackageConfig();
        autoGenerator.setPackageInfo(packageConfig);
        // 策略项配置
        StrategyConfig strategyConfig = getStrategyConfig();
        autoGenerator.setStrategy(strategyConfig);
        // 模板配置
        TemplateConfig templateConfig = getTemplateConfig();
        autoGenerator.execute();
    }

    // 数据库相关配置
    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        // schemaname [public]
        dataSourceConfig.setSchemaName("public");
        // 设置数据库字段类型转换类
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        // 驱动连接的URL
        dataSourceConfig.setUrl(
                "jdbc:mysql://123.56.205.166:3306/industrydb?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        // 驱动名称
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        // 数据库连接用户名
        dataSourceConfig.setUsername("db_v3");
        // 密码
        dataSourceConfig.setPassword("db_v3");
        return dataSourceConfig;
    }

    // 全局配置
    private static GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        // 生成文件的输出目录 [默认为D://]
        globalConfig.setOutputDir("E:\\generators");
        // 是否覆盖已有文件 [false]
        globalConfig.setFileOverride(true);
        // 是否打开输出目录 [true]
        globalConfig.setOpen(true);
        // 是否在xml中添加二级缓存配置 [true]
        globalConfig.setEnableCache(true);
        // 设置作者(在生成的注解中显示) [默认为空]
        globalConfig.setAuthor("fyh");
        // 开启kotlin模式 [false]
        globalConfig.setKotlin(false);
        // 开启ActiveRecord模式 [false]
        globalConfig.setActiveRecord(true);
        // 开启BaseResultMap [false]
        globalConfig.setBaseResultMap(true);
        // 开启baseColumnList [false]
        globalConfig.setBaseColumnList(true);
        // mapper命名格式
        globalConfig.setMapperName("%sMapper");
        // xml命名格式
        globalConfig.setXmlName("%sMapper");
        // service命名格式
        globalConfig.setServiceName("%sService");
        // serviceImpl命名格式
        globalConfig.setServiceImplName("%sServiceImpl");
        // controller命名格式
        globalConfig.setControllerName("%sController");
        // 主键ID类型
        globalConfig.setIdType(IdType.AUTO);
        // 时间类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        return globalConfig;
    }

    // 跟包相关的配置项
    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        packageConfig.setParent("com.lvgu.industrynew");
        // 父包模块名
        packageConfig.setModuleName("");
        // Entity包名
        packageConfig.setEntity("entity");
        // Service包名
        packageConfig.setService("service");
        // Service Impl包名
        packageConfig.setServiceImpl("service.impl");
        // mapper包名
        packageConfig.setMapper("dao");
        // mapper xml包名
        packageConfig.setXml("dao.xml");
        // controller包名
        packageConfig.setController("controller");
        return packageConfig;
    }

    // 策略配置项
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        // 是否大写命名
        strategyConfig.setCapitalMode(false);
        // 数据库表映射到实体的命名策略 [NamingStrategy.nochange]
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略,未指定按照 naming 执行
        strategyConfig.setColumnNaming(NamingStrategy.no_change);
        // 表前缀
        strategyConfig.setTablePrefix(new String[] {});
        // 字段前缀
        strategyConfig.setFieldPrefix(new String[] {});
        // 自定义继承的Entity类全称，带包名
        // strategyConfig.setSuperEntityClass();
        // 自定义基础的Entity类，公共字段
        // strategyConfig.setSuperEntityColumns();
        // 自定义继承的Mapper类全称，带包名
        strategyConfig.setSuperMapperClass(ConstVal.SUPER_MAPPER_CLASS);
        // 自定义继承的Service类全称，带包名
        strategyConfig.setSuperServiceClass(ConstVal.SUPER_SERVICE_CLASS);
        // 自定义继承的ServiceImpl类全称，带包名
        strategyConfig.setSuperServiceImplClass(ConstVal.SUPER_SERVICE_IMPL_CLASS);
        // 自定义继承的Controller类全称，带包名
        // strategyConfig.setSuperControllerClass();
        // 需要包含的表名（与exclude二选一配置） [null]
//        strategyConfig.setInclude("my_user");
        // 需要排除的表名 [null]
        // strategyConfig.setExclude();
        // strategyConfig.setInclude("datasource_config");
        // 是否生成字段常量（默认 false）
        strategyConfig.setEntityColumnConstant(false);
        // 是否为构建者模式 (默认false) 构建者模式:set方法返回this
        strategyConfig.setEntityBuilderModel(false);
        // 是否为lombok模型(默认false0
        strategyConfig.setEntityLombokModel(true);
        // Boolean类型字段是否移除is前缀（默认 false）
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(false);
        // 设置Controller为RestController [false]
        strategyConfig.setRestControllerStyle(true);
        // mapping中驼峰转连字符 [false]
        strategyConfig.setControllerMappingHyphenStyle(false);
        // 是否生成实体时，生成字段注解
        strategyConfig.setEntityTableFieldAnnotationEnable(false);
        // 乐观锁属性名称
        // strategyConfig.setVersionFieldName();
        // 逻辑删除属性名称
        // strategyConfig.setLogicDeleteFieldName();
        // 表填充字段 [null]
        strategyConfig.setTableFillList(null);
        return strategyConfig;
    }

    // 设置生成模板,如果不设置,则使用mybatisplus默认的模板,默认模板在mybatisplus的resources/templates文件夹下面
    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("templates/controller.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setMapper("templates/mapper.java");
        templateConfig.setXml("templates/mapperxml.java");
        return templateConfig;
    }
}
