package ProductsAndCategories.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProductsAndCategories.Models.CategoryModel;

@Repository
public interface CategoryRepo extends CrudRepository<CategoryModel, Long> {
	
	//findAll
	List<CategoryModel> findAll();
}
