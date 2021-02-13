package com.bituum.spring.mvc.controllers;


import com.bituum.spring.mvc.dao.FlowerDaoImpl;
import com.bituum.spring.mvc.models.Flower;
import com.bituum.spring.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerDaoImpl flowerDao;

    @GetMapping
    public String showall(Model model){
        model.addAttribute("allFlowers", flowerDao.showAll());
        return "flower/show_all";
    }

    @GetMapping("/new")
    public String newFlower(Model model){
        model.addAttribute("flower", new Flower());
        return "/flower/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("flower") Flower flower){
        flowerDao.add(flower);
        return "redirect:/flower";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", flowerDao.showById(id));
        return "/flower/index";
    }

    @GetMapping("/{id}/edit")
    public String change(@PathVariable("id") int id, Model model){
        Flower flower = flowerDao.showById(id);
        model.addAttribute("flower", flower);
        return "/flower/change";
    }

    @PostMapping("/{id}/edit")
    public String change(@ModelAttribute("flower") Flower flower){
        flowerDao.update(flower);
        return "redirect:/flower";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("allUser") Flower flower){
        flowerDao.delete(flower);
        return "redirect:/flower";
    }


}
