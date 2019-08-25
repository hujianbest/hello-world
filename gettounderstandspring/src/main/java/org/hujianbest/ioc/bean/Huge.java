package org.hujianbest.ioc.bean;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Huge {

    public  Huge(){
        System.out.println("调用了无参构造器");
    }
    @PostConstruct
    public void Huge(){
        System.out.println("调用了@PostConstruct");
    }
    public String say(){
        return "I'm huge";
    }
}
