package com.bituum.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MyController {
    /*private final UserDao userDao;
    @Autowired
    public MyController(UserDao userDao) {
        this.userDao = userDao;
    }*/
/*
    @GetMapping("/user")
    public String showFirstView(){
        return "main";
    }*/

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("Hello");
        return "/user/showall";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){

        return null;
    }
}
