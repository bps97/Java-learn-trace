package cn.bps.spring.configuration.classes.entry;

import java.util.Date;

public class BeanXX {

    private String name;
    private Integer age;
    private Date birthday;


    public BeanXX(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "["+name+"\t"+age+"]\n"+birthday;
    }
}
