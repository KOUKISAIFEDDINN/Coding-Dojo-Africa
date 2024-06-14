package com.travels.savetravels.controllers;

import com.travels.savetravels.models.Expense;
import com.travels.savetravels.repositories.ExpenseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Still working on this Assignment got error 404 Not Found
@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public String listExpenses(@ModelAttribute("expense") Expense expense , Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        model.addAttribute("expense", expense);
        return "expenses.jsp";
    }

    @PostMapping("/add")
    public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/expenses";
        }
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String editExpenseForm(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid expense id: " + id));
        model.addAttribute("expense", expense);
        return "edit-expense.jsp";
    }


    @PostMapping("/edit/{id}")
    public String updateExpense(@Valid @PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-expense.jsp";
        }
        expense.setId(id);
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expenses";
    }

    @GetMapping("/{id}")
    public String showExpenseDetails(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid expense id: " + id));
        model.addAttribute("expense", expense);
        return "expense-details.jsp";
    }
}
