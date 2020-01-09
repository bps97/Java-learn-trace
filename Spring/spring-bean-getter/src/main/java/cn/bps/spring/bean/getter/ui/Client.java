package cn.bps.spring.bean.getter.ui;

import cn.bps.spring.bean.getter.service.impl.AccountServiceImpl;
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


//        AccountServiceImpl service =  (AccountServiceImpl)getBeanByConstruction();
//        AccountServiceImpl service =  (AccountServiceImpl)getBeanByFactoryMethod();
        AccountServiceImpl service =  (AccountServiceImpl) getBeanByStaticFactoryMethod();

        service.saveAccount();


    }

    public static Object getBeanByConstruction(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        return context.getBean("accountService");

    }

    public static Object getBeanByFactoryMethod(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        return context.getBean("accountService");
    }


    public static Object getBeanByStaticFactoryMethod(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        return context.getBean("accountService");
    }


}
