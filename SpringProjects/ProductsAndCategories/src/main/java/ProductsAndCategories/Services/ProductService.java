package ProductsAndCategories.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductsAndCategories.Models.ProductModel;
import ProductsAndCategories.Repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	//find book by id
	public ProductModel findById(Long id) {
		Optional<ProductModel> productResult = productRepo.findById(id);
		if(productResult.isPresent()) {	
			return productResult.get();
		} else {
			return null;
		}
	}
	
	// get all product
	public List<ProductModel> getAllProduct(){
		return productRepo.findAll();
	}
	
	//create new product
	public ProductModel createProduct(ProductModel newCreatedProduct) {
		return productRepo.save(newCreatedProduct);
	}
	
	//update product
	public ProductModel updateProduct(ProductModel updateProduct) {
		return productRepo.save(updateProduct);
	}
	
	//delete product by id
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	//product detail
	public ProductModel productDetails(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
}
