package com.dojoandninjas.testdojoandninjas.controller;

import com.dojoandninjas.testdojoandninjas.model.Dojo;
import com.dojoandninjas.testdojoandninjas.services.DojosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class DojoController {

    @Autowired
    private DojosServices dojosServices;

    @GetMapping("/")
    private String index(){
        return "redirect:/dojos/new";
    }

    @GetMapping("/dojos/new")
    private String getAllDojos(@ModelAttribute("newDojo") Dojo dojo , Model model){
        List<Dojo> allDojos = dojosServices.allDojos();
        model.addAttribute("allDojos" , allDojos);
        return "home.jsp";
    }
    @PostMapping("/dojos/new")
    public String createDojo(@Valid @ModelAttribute("newDojo") Dojo dojos, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Dojo> allDojos = dojosServices.allDojos();
            model.addAttribute("allDojos", allDojos);
            return "home.jsp";
        }

        dojosServices.createDojo(dojos);
        return "redirect:/dojos/new";
    }

    @GetMapping("/dojos/{id}")
    private String getAllNinjas(@PathVariable("id")Long id , Model model){
        Dojo savedDojos = dojosServices.findOneDojoById(id);
        model.addAttribute("allDojos" ,savedDojos);
        return "allNinjas.jsp" ;
    }
}
