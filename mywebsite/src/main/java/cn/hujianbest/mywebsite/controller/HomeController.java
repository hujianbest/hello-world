package cn.hujianbest.mywebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @author bestJ
 * @since 1.0.0
 */
@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/cube")
    public String cube(){
        return "cube";
    }
}
