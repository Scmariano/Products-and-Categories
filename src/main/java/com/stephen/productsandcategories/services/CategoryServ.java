package com.stephen.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.productsandcategories.models.Category;
import com.stephen.productsandcategories.models.Product;
import com.stephen.productsandcategories.repositories.CategoryRepo;

@Service
public class CategoryServ {
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findCategoryId(Long id) {
		Optional<Category>optCategory = categoryRepo.findById(id);
		if(optCategory.isPresent()) {
			return optCategory.get();
		}else {
			return null;
		}
	}
	
	public List<Category> getProducts(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> notInProducts(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}
}
