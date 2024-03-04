package com.piashraful.Spring.boot.learing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController{
    @GetMapping("/")
    public String sayMessage(){
        return "Hello Piash";
    }

}

