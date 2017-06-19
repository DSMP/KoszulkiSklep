package com.koszulki.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    public ModelAndView hello(Model model) {
//        return "Greetings from Spring Boot!";
        return new ModelAndView("redirect:/koszulki");
    }
    @RequestMapping("")
    public ModelAndView index(Model model) {
//        return "Greetings from Spring Boot!";
        return new ModelAndView("redirect:/koszulki");
    }
    @RequestMapping("/admin")
    public ModelAndView adminPanel(Model model) {
//        return "Greetings from Spring Boot!";
        return new ModelAndView("admin/admin-panel");
    }
    @GetMapping("/international")
    public ModelAndView getInternationalPage() {
        return new ModelAndView("redirect:koszulki");
    }
}
