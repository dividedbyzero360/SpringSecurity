package com.luv2code.springsecurity.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
