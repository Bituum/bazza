package com.bituum.spring.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("messege", "Testing string");


        return "login/login";
    }
}
