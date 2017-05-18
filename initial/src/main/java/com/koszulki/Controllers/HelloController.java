package com.koszulki.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index(Model model) {
        return "Greetings from Spring Boot!";
    }
    
}
