package SaveTravels4.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import SaveTravels4.Models.ExpensesModel;

@Repository
public interface TravelRepo extends CrudRepository<ExpensesModel, Long> {
	List<ExpensesModel> findAll();
}
