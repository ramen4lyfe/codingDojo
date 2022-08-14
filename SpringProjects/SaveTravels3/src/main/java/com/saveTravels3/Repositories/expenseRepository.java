package com.saveTravels3.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.saveTravels3.Models.ExpenseModel;

public interface expenseRepository extends CrudRepository<ExpenseModel, Long> {
	List<ExpenseModel> findAll();
}
