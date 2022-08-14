package ProductsAndCategories.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ProductsAndCategories.Services.CategoryService;
import ProductsAndCategories.Services.ProductService;

@Controller
public class NewCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired ProductService productService;
	
	
}
