# MGB MyBatis Generator

一个生成MyBatis的代码生成器
自动生成的mapper.xml文件，model对象(pojo)和mapper类的工具。


MGB为配置中的每个表生成简单的CRUB函数生成sql,如下
- insert
- update by primary key
- update by example (可以编辑where的条件)
- delete by primary key
- delete by example
- select by primary key
- select by example
- count by example
> 如果对应的表没有主键则不会生成有关primary的函数




使用：

在resources中创建一mbg的配置文件，用来编写相关的生成配置。
默认的是genratorConfig.xml。MGB就是从该配置文件自动生成pojo，mapper以及对应的xml映射文件。

配置
最简单的配置文件需要如下几个标签
- jdbcConnection 
配置数据源
- javaModelGenerator
指定目标目录生成相应的pojo类。
- sqlMapGenerator
指定目标目录生成相应的mapper文件(xml)。
- javaClientGenerator(这个可以没有)
在目标目录生成相应的接口和mapper类(dao层)。
- table
配置表如何映射成对应的类，开启什么样的接口。
> 还有许多配置，详见[官方文档](http://mybatis.org/generator/)

启动MBG
需要编写一些代码通过类加载器生成

```
List<String > warnings = new ArrayList<String >();
boolean overwrite = true;

File configFile = new File(MyBatisGenerator.class.getClassLoader()
        .getResource("generatorConfig.xml").toURI());
ConfigurationParser cp = new ConfigurationParser(warnings);
Configuration config = cp.parseConfiguration(configFile);
ShellCallback callback = new DefaultShellCallback(overwrite);
MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

myBatisGenerator.generate(null);



```

在已经有了Mybatis等相关依赖后, 只需要编写mbg相关配置, 配合maven插件可直接生成