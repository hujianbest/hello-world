package com.example.springaoptest;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Pointcut("execution(* com.example.springaoptest.Performance.perform())")
    public void performance(){}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint pj){
        try {
            System.out.println("准备看演出");
            pj.proceed();
            System.out.println("看完鼓掌");
        }catch (Throwable e){
            System.out.println("演出故障");
        }
    }
}
