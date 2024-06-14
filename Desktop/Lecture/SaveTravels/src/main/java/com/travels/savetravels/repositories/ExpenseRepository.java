package com.travels.savetravels.repositories;

import com.travels.savetravels.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
