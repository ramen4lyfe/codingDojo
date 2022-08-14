package com.saveTravels3.Controllers;

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

import com.saveTravels3.Models.ExpenseModel;
import com.saveTravels3.Services.expenseService;

@Controller
public class addExpensesController {
	
	@Autowired
	private expenseService expenseService;

	@GetMapping("/")
	public String redirect() {
		return "redirect:/expenses";
	}
	// landing page
	@GetMapping("/expenses")
	public String addExpenses(@ModelAttribute ("expense") ExpenseModel expense, Model model) {
		model.addAttribute("expenses", expenseService.all());
		return "addExpenses.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", expenseService.all());
			return "addExpense.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	//show expense details
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expenses", expenseService.find(id));
		return "expenseDetails.jsp";
	}
	
	
	@DeleteMapping("/expenses/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/expenses";
	}
	
	//edit page
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.find(id));
		model.addAttribute("expenses", expenseService.all());
		return "editExpense.jsp";
	}
	
	//to update
	@PutMapping("/expenses/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", expenseService.all());
			return "editExpense.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}
}
