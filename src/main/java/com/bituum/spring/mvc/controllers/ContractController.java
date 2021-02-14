package com.bituum.spring.mvc.controllers;


import com.bituum.spring.mvc.dao.ContractDao;
import com.bituum.spring.mvc.dao.ContractDaoImpl;
import com.bituum.spring.mvc.models.Contract;
import com.bituum.spring.mvc.models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractDao contractDao;

    @GetMapping
    public String showall(Model model){
        model.addAttribute("allContracts", contractDao.showAll());
        return "contract/show_all";
    }

    @GetMapping("/new")
    public String newConract(Model model){
        model.addAttribute("contract", new Contract());
        return "/contract/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("contract") Contract contract){
        contractDao.add(contract);
        return "redirect:/contract";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("contract", contractDao.showById(id));
        return "/contract/index";
    }

    @GetMapping("/{id}/edit")
    public String change(@PathVariable("id") int id, Model model){
        Contract contract = contractDao.showById(id);
        model.addAttribute("contract", contract);
        return "/contract/change";
    }

    @PostMapping("/{id}/edit")
    public String change(@ModelAttribute("contract") Contract contract){
        contractDao.update(contract);
        return "redirect:/contract";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("allUser") Contract contract){
        contractDao.delete(contract);
        return "redirect:/contract";
    }
}
