package com.asac05b.clone_airbnb_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/aaa")
    public String s(){
        return "sssssssssssss";
    }
}
