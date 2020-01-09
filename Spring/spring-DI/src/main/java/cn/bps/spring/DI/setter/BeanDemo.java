package cn.bps.spring.DI.setter;

import java.util.Date;

public class BeanDemo {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toString(){
        return name+"\t\t"+age.toString()+"\t"+birthday.toString();
    }


}
