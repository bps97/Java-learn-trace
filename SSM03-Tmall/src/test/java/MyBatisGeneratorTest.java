import cn.bps.dao.Category;
import cn.bps.mapper.CategoryMapper;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyBatisGeneratorTest {
    /*
    public static void main(String[] args) throws
            URISyntaxException, IOException,
            XMLParserException, InvalidConfigurationException,
            SQLException, InterruptedException {

        List<String > warnings = new ArrayList<String >();

        boolean overwrite = true;

        File configFile = new File(MyBatisGenerator.class.getClassLoader()
                .getResource("generatorConfig.xml").toURI());

        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(configFile);

        ShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        myBatisGenerator.generate(null);

        System.out.println("succeed");

    }

      */

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void test(){
        Category category = new Category();
        category.setName("分类1");
        categoryMapper.insert(category);

    }
}
