package com.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saveTravels.models.Expense;
import com.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService { //CRUD queries
	
	// adding the expense repository as a dependency
    private final ExpenseRepository repo;
    
    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }
    // query to returns all the expenses
    public List<Expense> all() {
        return repo.findAll();
    }
    // query to creates an expense
    public Expense create(Expense b) {
        return repo.save(b);
    }
    // query to updates an expense
    public Expense update(Expense b) {
        return repo.save(b);
    }
    // query to retrieves an expense
    public Expense find(Long id) {
        Optional<Expense> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    public void delete(Long id) {
    	repo.deleteById(id);
    }

}