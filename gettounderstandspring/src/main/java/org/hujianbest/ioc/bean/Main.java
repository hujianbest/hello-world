package org.hujianbest.ioc.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 依赖注入使用在被Spring管理的类中，简单说也就是加了@Controller @Service @Repository @Component注解的类中
 * 在没有被Spring管理的类中获取bean需使用ApplicationContext.getBean()
 */
public class Main {

    private  static AutoBean autoBean;

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        autoBean = context.getBean("autoBean", AutoBean.class);
        System.out.println(autoBean.say());
    }
}
