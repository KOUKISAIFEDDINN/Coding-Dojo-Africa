package com.codingdojo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.book.entity.Book;
import com.codingdojo.book.entity.Library;
import com.codingdojo.book.service.BookService;
import com.codingdojo.book.service.LibraryService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	LibraryService libService;
	
	@RequestMapping("/book")
	public String newBook(@ModelAttribute("book") Book book,Model model) {
		List<Library> libraries = libService.getAll();
		model.addAttribute("libraries", libraries);
		return "book/createForm.jsp";
	}
    @PostMapping("/book")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/createForm.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/book";
        }
    }
    
    @GetMapping("/all")
    public String showAll(Model model, HttpSession session) {
    Long userId=	(Long) session.getAttribute("user_id");
    if(userId==null) {
    	return "redirect:/index";
    }
    	List<Book> books = bookService.getAllBook() ;
    	model.addAttribute("books", books);
    	return "book/list.jsp";
    	}
    
    /** edit*/
    @GetMapping("/edit/book/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Book book = bookService.findOne(id);
    	model.addAttribute("book", book);
    	return "book/edit.jsp";
    }
    
    @PutMapping("/book/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/all";
        }
    }
    
    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    	 return "redirect:/all";
    }
	
}
