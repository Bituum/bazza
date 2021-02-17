package com.bituum.spring.mvc.controllers;


import com.bituum.spring.mvc.dao.CompositionDao;
import com.bituum.spring.mvc.dao.FlowerDTO;
import com.bituum.spring.mvc.dao.FlowerDao;
import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/composition")
public class CompositionController {
    @Autowired
    private CompositionDao compositionDao;

    @Autowired
    private FlowerDao flowerDao;

    @GetMapping
    public String showall(Model model){
        List<Composition> list = compositionDao.showAll();
        System.out.println(list);
        model.addAttribute("allCompositions", list);
        return "composition/show_all";
    }

    @GetMapping("/new")
    public String newComposition(Model model){
        List<Flower> flowerList = (List<Flower>) flowerDao.showAll();
        model.addAttribute("flowerList",flowerList);
        model.addAttribute("composition", new Composition());
        return "/composition/new";
    }

    @PostMapping("/new")
    public String create(@RequestParam("title") String title, @RequestParam("compositionFlower")  String[] flowers){
        String []tmpStrings = flowers;
        List<Flower> flow = new ArrayList<>();
        for(String i : tmpStrings){
            flow.add(flowerDao.showById(Integer.parseInt(i)));
            System.out.println(i);
        }
            Composition composition = new Composition();
            System.out.println(title);
            composition.setTitle(title);
            composition.setCompositionFlower(flow);
            System.out.println(composition);
            System.out.println(composition.getTitle());
            System.out.println(composition.getCompositionFlower());
            compositionDao.add(composition);
        return "redirect:/composition";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("composition", compositionDao.showById(id));
        model.addAttribute("flowerList", flowerDao.showAll());
        return "/composition/index";
    }

    @GetMapping("/{id}/edit")
    public String change(@PathVariable("id") int id, Model model){
        List<Flower> flowerList = (List<Flower>) flowerDao.showAll();
        Composition composition = compositionDao.showById(id);
        model.addAttribute("flowerList", flowerList);
        model.addAttribute("composition", composition);
        return "/composition/change";
    }

    @PostMapping("/{id}/edit")
    public String change(@RequestParam("title") String title, @RequestParam("compositionFlower")  String[] flowers){
        String []tmpStrings = flowers;
        List<Flower> flow = new ArrayList<>();
        for(String i : tmpStrings){
            flow.add(flowerDao.showById(Integer.parseInt(i)));
            System.out.println(i);
        }
        Composition composition = new Composition();
        System.out.println(title);
        composition.setTitle(title);
        composition.setCompositionFlower(flow);
        System.out.println(composition);
        System.out.println(composition.getTitle());
        System.out.println(composition.getCompositionFlower());
        compositionDao.update(composition);
        return "redirect:/composition";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("composition") Composition composition){
        compositionDao.delete(composition);
        return "redirect:/composition";
    }



}
