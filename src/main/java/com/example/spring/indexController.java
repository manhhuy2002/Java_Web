package com.example.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class indexController {
    @PostMapping("/redirect")
    protected String doPost() {
        return "upload";
    }

}
