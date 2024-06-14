package com.codingdojo.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.book.entity.Library;
import com.codingdojo.book.service.LibraryService;

import jakarta.validation.Valid;

@Controller
public class LibraryController {

	
	private LibraryService libService;
	
	public LibraryController(LibraryService libServ) {
		this.libService = libServ;
	}
	
	@RequestMapping("/library/new")
	public String newLib(@ModelAttribute("library") Library lib) {
		return "book/createLib.jsp";
	}
	
	@PostMapping("/library")
	public String createLibrary(@Valid @ModelAttribute("library") Library lib, BindingResult result) {
        if (result.hasErrors()) {
            return "book/createLib.jsp";
        } else {
           libService.create(lib);
            return "redirect:/all";
        }
	}
	
	@GetMapping("/libs")
	public String getAllLibs(Model model) {
		List<Library> libs = libService.getAll();
		
		model.addAttribute("libs", libs);
		
		return "book/LibList.jsp";
	}
}
