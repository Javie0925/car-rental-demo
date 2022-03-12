package com.carrental.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /**
     * return index page
     * @return
     */
    @GetMapping({"/index","/"})
    public String index(){
        return "index";
    }
}
