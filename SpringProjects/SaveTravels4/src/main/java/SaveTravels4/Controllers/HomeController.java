package SaveTravels4.Controllers;

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

import SaveTravels4.Models.ExpensesModel;
import SaveTravels4.Services.TravelService;

@Controller
public class HomeController {

	@Autowired
	private TravelService travelService;

//NOTE: ModelAttribute and addattribute for home route and post route must be the same!!!
// home route for dashboard
	@GetMapping("/expenses")
	public String dashboard(Model model, @ModelAttribute("newExpense") ExpensesModel expense) {
		model.addAttribute("expenseItem", travelService.getAllExpenses());
		return "index.jsp";
	}
	
// post route for create new expense	
	@PostMapping("/expenses/create")
	public String createExpense(Model model, @Valid @ModelAttribute("newExpense") ExpensesModel expense, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("expenseItem", travelService.getAllExpenses());
			return "index.jsp";
		}else {
		travelService.createExpense(expense);
		return "redirect:/expenses";
		}
	}

// show expense details
	@GetMapping("/expenses/{id}/details")
	public String expenseDetails(Model model, @PathVariable("id") Long id) {
		model.addAttribute("expensesDetails", travelService.expenseDetails(id));
		return "details.jsp";
	}
	
// route to edit expense entry	
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(Model model, @PathVariable("id") Long id) {
		ExpensesModel expense = travelService.findById(id);
		model.addAttribute("editExpense", travelService.expenseDetails(id));
		model.addAttribute("newExpense", travelService.findById(id));
		return "edit.jsp";
	}
	
// update entry
	//NOTE: bingdingresult has to follow immediately after ModelAttribute
	@PutMapping("/expenses/{id}/update")
	public String updateExpense(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("editExpense") ExpensesModel expense, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("expenseItem",travelService.getAllExpenses());
			return "edit.jsp";
		} else {
			travelService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
//Delete expense
	@DeleteMapping("/expenses/{id}/delete")
	public String deleteExpense(@PathVariable("id") Long id) {
		travelService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
