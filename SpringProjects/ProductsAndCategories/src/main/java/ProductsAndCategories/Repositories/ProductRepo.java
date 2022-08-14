package ProductsAndCategories.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProductsAndCategories.Models.ProductModel;

@Repository
public interface ProductRepo extends CrudRepository<ProductModel, Long> {

	//findAll
	List<ProductModel> findAll();
}
