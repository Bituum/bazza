package com.bituum.spring.mvc.controllers;


import com.bituum.spring.mvc.dao.CompositionDao;
import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/composition")
public class CompositionController {
    @Autowired
    private CompositionDao compositionDao;

    @GetMapping
    public String showall(Model model){
        model.addAttribute("allCompostions", compositionDao.showAll());
        return "composition/show_all";
    }

    @GetMapping("/new")
    public String newComposition(Model model){
        model.addAttribute("composition", new Composition());
        return "/composition/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("composition") Composition composition){
        compositionDao.add(composition);
        return "redirect:/composition";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("composition", compositionDao.showById(id));
        return "/composition/index";
    }

    @GetMapping("/{id}/edit")
    public String change(@PathVariable("id") int id, Model model){
        Composition composition = compositionDao.showById(id);
        model.addAttribute("composition", composition);
        return "/composition/change";
    }

    @PostMapping("/{id}/edit")
    public String change(@ModelAttribute("composition") Composition composition){
        compositionDao.update(composition);
        return "redirect:/composition";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("allUser") Composition composition){
        compositionDao.delete(composition);
        return "redirect:/composition";
    }

}
