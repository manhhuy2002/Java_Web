package com.example.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Test {
    @GetMapping("/uploadFailure")
    public String UploadFailure(){
        return "uploadFailure";
    }
}
