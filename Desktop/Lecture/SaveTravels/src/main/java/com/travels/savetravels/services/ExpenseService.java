package com.travels.savetravels.services;

import com.travels.savetravels.models.Expense;
import com.travels.savetravels.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService (ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid expense id: "+ id));
    }

    public void saveExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public void deleteExpense (Long id) {
        expenseRepository.deleteById(id);
    }
}
