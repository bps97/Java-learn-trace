package cn.bps.spring.DI.constructor;

import java.util.Date;

public class BeanDemo {

    private String name;
    private Integer age;
    private Date birthday;

    public BeanDemo(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public String toString(){
        return name+"\t"+age.toString()+"\t"+birthday.toString();
    }


}
