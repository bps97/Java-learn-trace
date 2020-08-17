package cn.bps.heam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
@MapperScan(basePackages = {"cn.bps.heam.mapper"})
public class SsmApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SsmApplication.class, args);
//        context.close();
    }

}
