package com.bituum.spring.mvc.controllers;

import com.bituum.spring.mvc.dao.UserDaoImpl;
import com.bituum.spring.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/login")
public class MyController {
    @Autowired
    private UserDaoImpl userdaoimpl;

    @GetMapping()
    public String gettingStarting(){
        return "/login/start";
    }

    @GetMapping("/auth")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "/login/auth";
    }

    @PostMapping("/auth")
    public String login(@ModelAttribute("user") User user, Model model){
        user = userdaoimpl.login(user);
        if(user != null){
            return "redirect:/login/menu";
        }else{
            model.addAttribute("no", false);
            return "redirect:/login";
        }

    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "/user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userdaoimpl.add(user);
        return "redirect:/login";
    }

    @GetMapping("/menu")
    public String menu(){
        return "/user/main_menu";
    }
}
