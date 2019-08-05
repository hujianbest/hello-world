package com.example.springaoptest;

import org.springframework.stereotype.Component;

@Component
public class Dance implements Performance{
    public void perform(){
        System.out.println("Perform Dancing");
    }
}
