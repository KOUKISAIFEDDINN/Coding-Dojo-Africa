package com.dojoandninjas.testdojoandninjas.controller;


import com.dojoandninjas.testdojoandninjas.model.Dojo;
import com.dojoandninjas.testdojoandninjas.model.Ninja;
import com.dojoandninjas.testdojoandninjas.services.DojosServices;
import com.dojoandninjas.testdojoandninjas.services.NinjasServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NinjaController {


    @Autowired
    private NinjasServices ninjasServices;

    @Autowired
    private DojosServices dojosServices;


    @GetMapping("/ninjas/new")
    private String indexNinja(@ModelAttribute("newNinjas")Ninja ninja , Model model){
        List<Ninja> allNinjas = ninjasServices.allNinjas();
        List<Dojo> allDojos = dojosServices.allDojos();
        model.addAttribute("allNinjas" , allNinjas);
        model.addAttribute("allDojos" , allDojos);

        return "ninja.jsp";
    }

    @PostMapping("/ninjas/new")
    public String newNinjas(@Valid @ModelAttribute("newNinjas") Ninja ninja , Model model , BindingResult result){
        if(result.hasErrors()){
            List<Ninja > allNinjas = ninjasServices.allNinjas();
            List<Dojo> allDojos = dojosServices.allDojos();
            model.addAttribute("allNinjas" , allNinjas);
            model.addAttribute("allDojos" , allDojos);
            return "ninja.jsp";
        }else{
            ninjasServices.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }


}
