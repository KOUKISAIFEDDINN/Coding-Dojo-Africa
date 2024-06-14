package com.dojoninja.dojosandninjas.controllers;

import com.dojoninja.dojosandninjas.models.Dojo;
import com.dojoninja.dojosandninjas.models.Ninja;
import com.dojoninja.dojosandninjas.services.DojoService;
import com.dojoninja.dojosandninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private DojoService dojoService;

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/new")
    public String showNinjaForm(Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninja", new Ninja());
        return "ninjas/newNinja";
    }

    @PostMapping("/new")
    public String createNinja(@ModelAttribute Ninja ninja) {
        ninjaService.save(ninja);
        return "redirect:/ninjas/showAll";
    }

    @GetMapping("/showAll")
    public String showAllNinjas(Model model) {
        List<Ninja> ninjas = ninjaService.findAll();
        model.addAttribute("ninjas", ninjas);
        return "ninjas/showAllNinjas";
    }
}