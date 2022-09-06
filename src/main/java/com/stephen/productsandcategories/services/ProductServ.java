package com.stephen.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.productsandcategories.models.Category;
import com.stephen.productsandcategories.models.Product;
import com.stephen.productsandcategories.repositories.ProductRepo;

@Service
public class ProductServ {
	
	@Autowired 
	private ProductRepo productRepo;
	
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	
	public Product findProductId(Long id) {
		Optional<Product>optProduct = productRepo.findById(id);
		if(optProduct.isPresent()) {
			return optProduct.get();
		}else {
			return null;
		}
	}
	
	public List<Product> getCategories(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> notInCategories(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public void deleteProduct(Product product) {
		productRepo.delete(product);
	}
}
