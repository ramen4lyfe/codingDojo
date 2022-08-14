package SaveTravels4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SaveTravels4.Models.ExpensesModel;
import SaveTravels4.Repositories.TravelRepo;

@Service
public class TravelService {
	
	//bring in repo
	@Autowired 
	private TravelRepo travelRepo;
	
	//Find expense by ID
	public ExpensesModel findById(Long id) {
		Optional<ExpensesModel> expenseResult = travelRepo.findById(id);
		if(expenseResult.isPresent()) {
			return expenseResult.get();
		}else {
			return null;
		}
	}
	
	//Get all expenses
	public List<ExpensesModel> getAllExpenses(){
		return travelRepo.findAll();
	}
	
	//Create new expense
	public ExpensesModel createExpense(ExpensesModel newExpense) {
		return travelRepo.save(newExpense);
	}
	
	//Update expense
	public ExpensesModel updateExpense(ExpensesModel updatedExpense) {
		return travelRepo.save(updatedExpense);
	}
	
	//Delete expense by ID
	public void deleteExpense(Long id) {
		travelRepo.deleteById(id);
	}
	
	//Expense details, show by id
	public ExpensesModel expenseDetails(Long id) {
		return travelRepo.findById(id).orElse(null);
	}
}
