package mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisPlusGenerator {

    public static void main(String[] args) {
        MybatisPlusGenerator generator = MybatisPlusGenerator.getSingle();
        generator.autoGeneration();
    }

    private static MybatisPlusGenerator single = null;

    private MybatisPlusGenerator() {
        super();
    }

    private static MybatisPlusGenerator getSingle() {
        if (single == null) {
            single = new MybatisPlusGenerator();
        }
        return single;
    }

    public static PackageConfig initPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("cn.bps.mms")
                .setController("controller")
                .setEntity("model.pojo");
        return packageConfig;
    }

    public void autoGeneration() {

        // 1.代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("bps")
//                .setOpen(false)
//                .setEntityName("%s")
//                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setDateType(DateType.ONLY_DATE)
                .setActiveRecord(false)
                .setEnableCache(false)
                //指定输出文件夹位置
                .setOutputDir("E:\\Workspace\\Java\\ssm-mms\\src\\main\\java")
                .setFileOverride(true)
                .setServiceName("%sService");

        // 3. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/mms?serverTimezone=GMT%2B8")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("bps")
                .setPassword("Pa$$word2020");

        // 4. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true)
                .setCapitalMode(true)
                // .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel);  /*下划线转驼峰*/

        // 5. 模板配置（无）
        /*TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("/templates/custom.entity.java");*/

        mpg.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(initPackageConfig()).execute();
    }
}
