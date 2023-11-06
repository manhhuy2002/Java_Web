package com.example.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class interceptorView {
    @RequestMapping("/test")
    public String test(){
        return "Interceptor? Contronller run first !!!";
    }
}
