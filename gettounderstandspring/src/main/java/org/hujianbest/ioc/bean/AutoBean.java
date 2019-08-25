package org.hujianbest.ioc.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AutoBean {

    @Resource
    Huge huge;

    public String say(){
        return huge.say();
    }
}
