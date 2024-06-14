package com.gold.renderbook.renderbook.controllers;


import com.gold.renderbook.renderbook.models.Book;
import com.gold.renderbook.renderbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }

    @GetMapping("/books/{id}")
    public String showBook (@PathVariable Long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}