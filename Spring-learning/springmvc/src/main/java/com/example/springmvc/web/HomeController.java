package com.example.springmvc.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//扫描并声明为bean
@RequestMapping("/")//声明要处理的请求，可用在类可用在方法
public class HomeController {

  @RequestMapping(method = GET)
  public String home(Model model) {
    return "home";
  }//返回模型和视图名

}
