package cn.bps.spring.bean.Inject.ui;

import cn.bps.spring.bean.Inject.service.impl.AccountServiceImpl;
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
        /**
         * 该模块叫bean的注入
         * 该测试方法内，都使用类路径的Ioc容器来获取Bean
         * bean的注入有三个手段：
         *         	1.采用默认构造函数创建，当类拥有默认构造函数，其没有除id和class以外的属性的配置。
         * 	        2.采用普通工厂中的方法创建对象(使用类中的某个方法创建对象，并存入spring容器)
         * 	        3.使用静态工厂中的静态方法创建对象（使用类中某个静态方法创建对象）
         */


        AccountServiceImpl service =  (AccountServiceImpl)getBeanByConstruction();
//        AccountServiceImpl service =  (AccountServiceImpl)getBeanByFactoryMethod();
//        AccountServiceImpl service =  (AccountServiceImpl) getBeanByStaticFactoryMethod();

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
