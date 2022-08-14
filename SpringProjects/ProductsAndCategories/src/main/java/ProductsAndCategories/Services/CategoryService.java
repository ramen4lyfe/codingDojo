package ProductsAndCategories.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductsAndCategories.Models.CategoryModel;
import ProductsAndCategories.Repositories.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	//find category by id
	public CategoryModel findById(Long id) {
		Optional<CategoryModel> productResult = categoryRepo.findById(id);
		if(productResult.isPresent()) {	
			return productResult.get();
		} else {
			return null;
		}
	}
	
	//create new category
	public CategoryModel createCategory(CategoryModel newCreatedCategory) {
		return categoryRepo.save(newCreatedCategory);
	}
	
	//update category
	public CategoryModel updateCategory(CategoryModel updateCategory) {
		return categoryRepo.save(updateCategory);
	}
	
	//delete category
	public void deleteCatagory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	//category details
	public CategoryModel categoryDetails(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
}
