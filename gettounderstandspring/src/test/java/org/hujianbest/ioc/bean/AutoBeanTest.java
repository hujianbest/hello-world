package org.hujianbest.ioc.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;



@Component
public class AutoBeanTest {

    @Test
    public void testAutowire() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        AutoBean autoBean = context.getBean("autoBean", AutoBean.class);
        assertEquals("This is AutoBean",autoBean.say());
    }
}
