package com.auth.loginandregistration.controllers;


import com.auth.loginandregistration.models.LoginUser;
import com.auth.loginandregistration.models.User;
import com.auth.loginandregistration.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("newUser" , new User());
        model.addAttribute("newLogin" ,new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {

        // TO-DO Later -- call a register method in the service
        // to do some extra validations and create a new user!
        userService.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }

        // No errors!
        // TO-DO Later: Store their ID from the DB in session,
        // in other words, log them in.
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {

        // Add once service is implemented:
        User user = userService.login(newLogin, result);

        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }

        // No errors!
        // TO-DO Later: Store their ID from the DB in session,
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session , Model model){
        Long user_id =(Long) session.getAttribute("user_id");
        User oneUser = userService.findUserById(user_id);
        if(user_id ==null){
            return "redirect:/";
        }
        model.addAttribute("oneUser" , oneUser);
        return "loginPage.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession s) {
        s.invalidate();
        return "redirect:/";
    }
}
