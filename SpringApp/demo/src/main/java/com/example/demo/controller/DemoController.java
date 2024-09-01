package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class DemoController {
    
    @GetMapping("/greet")
    public String greet() {
        return "Hello World !";
    }
    
}
