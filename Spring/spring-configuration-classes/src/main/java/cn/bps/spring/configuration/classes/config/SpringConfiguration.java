package cn.bps.spring.configuration.classes.config;


import cn.bps.spring.configuration.classes.entry.BeanXX;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
@ComponentScan(basePackages = "cn.bps.spring.configuration.classes.entry")
public class SpringConfiguration {


    /**
     * @Bean将当前方法的返回值作为bean存入容器
     * @return
     */
    @Bean(name = "bean")
    public BeanXX createBean(String name, Integer age, Date birthday){
        return new BeanXX(name,age,birthday);
    }


    @Bean(name = "name")
    public String getName(){
        return "Tom";
    }

    @Bean(name = "age")
    public Integer getAge(){
        return 18;
    }

    @Bean(name = "now")
    public Date getBirthday(){
        return new Date();
    }


}
