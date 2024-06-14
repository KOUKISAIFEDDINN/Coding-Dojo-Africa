package com.gold.renderbook.renderbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gold.renderbook.renderbook.models.Book;
import com.gold.renderbook.renderbook.services.BookService;

@RestController
public class BooksAPI {
    private final BookService bookService;

    @Autowired
    public BooksAPI(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }

    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="numOfPages") Integer numOfPages) {
        Book book = new Book(title, description, language, numOfPages);
        return bookService.createBook(book);
    }

    @GetMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

    @PutMapping("/api/books/{id}")
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }

    @DeleteMapping("api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
