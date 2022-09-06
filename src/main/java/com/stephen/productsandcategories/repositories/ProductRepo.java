package com.stephen.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.productsandcategories.models.Category;
import com.stephen.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	
	List<Product>findAll();
	List<Product>findAllByCategories(Category category);
	List<Product>findByCategoriesNotContains(Category category);
	List<Product>findByCategoriesId(Long categoryId);
	Optional<Product> findById(Long id);
}
