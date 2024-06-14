package com.dojoninja.dojosandninjas.controllers;

import com.dojoninja.dojosandninjas.models.Dojo;
import com.dojoninja.dojosandninjas.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dojos")
public class DojoController {

    @Autowired
    private DojoService dojoService;

    @GetMapping("/new")
    public String showDojoForm(Model model) {
        model.addAttribute("dojo", new Dojo());
        return "dojos/newDojo";
    }

    @PostMapping("/new")
    public String createDojo(@ModelAttribute Dojo dojo) {
        dojoService.save(dojo);
        return "redirect:/dojos/" + dojo.getId();
    }

    @GetMapping("/{id}")
    public String showDojo(@PathVariable Long id, Model model) {
        Dojo dojo = dojoService.findById(id);
        if (dojo == null) {
            return "redirect:/dojos/new";
        }

        model.addAttribute("dojo", dojo);
        return "dojos/showDojo";
    }
}
