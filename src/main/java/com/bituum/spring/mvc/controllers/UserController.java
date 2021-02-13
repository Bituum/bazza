package com.bituum.spring.mvc.controllers;

import com.bituum.spring.mvc.dao.UserDaoImpl;
import com.bituum.spring.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDaoImpl userdaoimpl;


    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("allUsers", userdaoimpl.showAll());
        return "/user/showall";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userdaoimpl.showById(id));
        return "/user/index";
    }

    @GetMapping("/{id}/edit")
    public String change(@PathVariable("id") int id, Model model){
        User person = userdaoimpl.showById(id);
        model.addAttribute("user", person);
        return "/user/change";
    }

    @PostMapping("/{id}/edit")
    public String change(@ModelAttribute("user") User user){
        userdaoimpl.update(user);
        System.out.println("SUKA EBANAYA BLYAT");
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("allUser") User user){
        userdaoimpl.delete(user);
        return "redirect:/users";
    }
}
