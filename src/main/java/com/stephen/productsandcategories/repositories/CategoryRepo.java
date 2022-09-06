package com.stephen.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.productsandcategories.models.Category;
import com.stephen.productsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	
	List<Category>findAll();
	List<Category>findAllByProducts(Product product);
	List<Category>findByProductsNotContains(Product product);
	List<Category>findByProductsId(Long ProductId);
	Optional<Category> findById(Long id);
}
