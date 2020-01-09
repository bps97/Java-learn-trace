package cn.bps.spring.DI.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ApplicationContext的三个实现类：
 *      CLassPathXmlApplicationContext: 可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。
 *      FIleSystemXmlApplicationContext:
 *      AnnotationConfigurationContext:

 */

public class Client {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        /*根据ID获取Bean*/
        System.out.println(context.getBean("bean1"));


        System.out.println(context.getBean("bean2"));


        System.out.println(context.getBean("bean3"));

        System.out.println(context.getBean("beanDemo"));


    }
}
