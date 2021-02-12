package com.bituum.spring.mvc.controllers;

import com.bituum.spring.mvc.dao.UserDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserDaoImpl userdaoimpl;


    @GetMapping("/showalluser")
    public String showAll(Model model){
        model.addAttribute("allUsers", userdaoimpl.showAll());
        return "/user/showall";
    }

    @GetMapping("user/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userdaoimpl.showById(id));
        return "/user/index";
    }


}
