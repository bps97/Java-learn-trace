package cn.bps.spring.DI.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component()
public class BeanDemo {

    @Value("张三")
    private String name;

    @Value("12")
    private Integer age;

    @Autowired
    private Date birthday;

    public String toString(){
        return birthday.toString()+"\t"+age+"\t"+name;
    }
}
