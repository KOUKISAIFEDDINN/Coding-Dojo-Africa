package com.auth.loginandregistration.controllers;


import com.auth.loginandregistration.models.Book;
import com.auth.loginandregistration.models.User;
import com.auth.loginandregistration.services.BookServices;
import com.auth.loginandregistration.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String home(@ModelAttribute("book") Book book , Model model , HttpSession session){
        Long userId = (Long) session.getAttribute("user_id");
        if(userId == null){
            return "redirect:/";
        }
        User oneUser = userService.findUserById(userId);
        model.addAttribute("user" , oneUser);
        List<Book> allBooks = bookServices.allBooks();
        model.addAttribute("allBooks" , allBooks);

        return "home.jsp";
    }
    @GetMapping("/new")
    public String newBooks(@ModelAttribute("book") Book book , Model model , HttpSession session){
        Long userId = (Long) session.getAttribute("user_id");
        if(userId == null){
            return "redirect:/";
        }
        User oneUser = userService.findUserById(userId);
        model.addAttribute("user" , oneUser);
        List<Book> allBooks = bookServices.allBooks();
        model.addAttribute("allBooks" , allBooks);
        return "createBook.jsp";
    }

    @PostMapping("/create")
    public String createBook(@Valid @ModelAttribute("book")Book book, Model model , BindingResult result , HttpSession session){
        Long userId  = (Long) session.getAttribute("user_id");
        if(userId == null){
            return "redirect:/";
        }
        if(result.hasErrors()){
            List<Book> allBooks = bookServices.allBooks();
            model.addAttribute("allBooks" , allBooks);
            return "createBook.jsp";
        }else{
            User oneUser = userService.findUserById(userId);
            book.setUser(oneUser);
            Book newBook = bookServices.createBook(book);
            return "redirect:/books";
        }

    }
    @GetMapping("/{id}")
    public String oneBook(@PathVariable("id") Long id, Model model){
        Book oneBook = bookServices.findBookById(id);
        if(oneBook!=null){
            model.addAttribute("oneBook" , oneBook);
            return "oneBook.jsp";
        }else{
            return "redirect:/books";
        }
    }

    @GetMapping("/{id}/edit")
    public String editBook(HttpSession session
            ,@PathVariable("id") Long id
            ,Model model ){

        Long userId  = (Long) session.getAttribute("user_id");
        if(userId == null){
            return "redirect:/";
        }
        Book oneBook = bookServices.findBookById(id);
       model.addAttribute("oneBook" , oneBook);
        return "edit1.jsp";
    }

    @PutMapping("/{id}/edit")
    public String editOneBook(@Valid @ModelAttribute("oneBook")Book book , BindingResult result , HttpSession session , Model model){

        if(result.hasErrors()){
            return"edit1.jsp";
        }else{
            User user = (User) userService.findUserById((Long) session.getAttribute("user_id"));
            book.setUser(user);
            bookServices.updateBook(book);
            return "redirect:/books";
        }
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {

        bookServices.deleteBook(id);

        return "redirect:/books";
    }
}
