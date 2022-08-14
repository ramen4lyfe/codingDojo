package com.saveTravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.saveTravels.models.Expense;
import com.saveTravels.services.ExpenseService;

@Controller
public class MainControllers {

	@Autowired 
	private ExpenseService expenses;

	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", expenses.all());
		return "index.jsp";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenses.find(id));
		model.addAttribute("expenses", expenses.all());
		return "edit.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenses.find(id));
		System.out.println("this is the platform solution.");
		return "show.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenses.all());
			return "index.jsp";
		}
		System.out.println("this is the platform solution.");
		expenses.create(expense);
		return "redirect:/expenses";
	}
	
	@PutMapping("/expenses/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenses.all());
			return "edit.jsp";
		}
		expenses.update(expense);	
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenses.delete(id);
		return "redirect:/expenses";
	}
}
