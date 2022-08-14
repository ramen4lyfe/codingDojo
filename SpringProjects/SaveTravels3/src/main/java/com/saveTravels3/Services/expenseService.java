package com.saveTravels3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveTravels3.Models.ExpenseModel;
import com.saveTravels3.Repositories.expenseRepository;


    
@Service
public class expenseService {
	@Autowired
	private expenseRepository expenseRepo;
	
	public expenseService(expenseRepository expeseRepo, expenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<ExpenseModel> all() {
		return this.expenseRepo.findAll();
	}
	
	// creates an expend
	public ExpenseModel createExpense(ExpenseModel expense) {
		return this.expenseRepo.save(expense);
	}
	
	// updates an expense
	public ExpenseModel updateExpense(ExpenseModel expense) {
		return this.expenseRepo.save(expense);
	}
	
	//retrieve an expense
	public ExpenseModel find(Long id) {
		Optional<ExpenseModel> optional = expenseRepo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
}


