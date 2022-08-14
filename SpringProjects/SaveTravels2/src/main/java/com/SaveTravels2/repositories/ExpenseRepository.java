package com.SaveTravels2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SaveTravels2.models.Expense;

@Repository
public interface ExpenseRepository  extends CrudRepository<Expense, Long> {
	List<Expense> findAll();
}
