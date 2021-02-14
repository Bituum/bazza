package com.bituum.spring.mvc.controllers;

import com.bituum.spring.mvc.dao.DeliverDaoImpl;
import com.bituum.spring.mvc.models.Deliver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/deliver")
public class DeliverController {

    @Autowired
    private DeliverDaoImpl deliverDao;

    @GetMapping
    public String showall(Model model){
        model.addAttribute("allDelivers", deliverDao.showAll());
        return "deliver/show_all";
    }

    @GetMapping("/new")
    public String newDeliver(Model model){
        model.addAttribute("deliver", new Deliver());
        return "/deliver/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("deliver") Deliver deliver){
        deliverDao.add(deliver);
        System.out.println(deliver.toString());
        return "redirect:/deliver";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("deliver", deliverDao.showById(id));
        return "/deliver/index";
    }

    @GetMapping("/{id}/edit")
    public String change(@PathVariable("id") int id, Model model){
        Deliver deliver = deliverDao.showById(id);
        model.addAttribute("deliver", deliver);
        return "/deliver/change";
    }

    @PostMapping("/{id}/edit")
    public String change(@ModelAttribute("deliver") Deliver deliver){
        deliverDao.update(deliver);
        return "redirect:/deliver";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("allUser") Deliver deliver){
        deliverDao.delete(deliver);
        return "redirect:/deliver";
    }
}
