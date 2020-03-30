package cn.bps.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @RequestMapping("/hello")
    public String hello(){
        return  "Hello Spring Boot";
    }

    @RequestMapping("/info")
    public String info(){
        return name + ": " + age;
    }


    @Autowired
    private StudentProperties studentProperties;

    @RequestMapping("/student")
    public String student(){
        return studentProperties.getName() + studentProperties.getAge();
    }

}
