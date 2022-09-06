package com.stephen.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stephen.productsandcategories.models.Category;
import com.stephen.productsandcategories.models.Product;
import com.stephen.productsandcategories.services.CategoryServ;
import com.stephen.productsandcategories.services.ProductServ;

@Controller
public class MainController {
	
	@Autowired ProductServ productServ;
	@Autowired CategoryServ categoryServ;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", productServ.allProducts());
		model.addAttribute("categories", categoryServ.allCategories());
		return "homePage.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "addProduct.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addProduct.jsp";
		}else {
			productServ.createProduct(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		return "addCategory.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addCategory.jsp";
		}else {
			categoryServ.createCategory(category);
			return "redirect:/";
		}
	}
	
	@GetMapping("/products/{productId}")
	public String showProduct(@PathVariable("productId") Long id, Model model) {
		Product product = productServ.findProductId(id);
		model.addAttribute("product", product);
		model.addAttribute("assignedCategories", categoryServ.getProducts(product));
		model.addAttribute("unassignedCategories", categoryServ.notInProducts(product));
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/{productId}")
	public String editProduct(@PathVariable("productId")Long id, 
			@RequestParam(value= "categoryId") Long categoryId, Model model) {
		Product product = productServ.findProductId(id);
		Category category = categoryServ.findCategoryId(categoryId);
		product.getCategories().add(category);
		productServ.updateProduct(product);
		model.addAttribute("assignedCategories", categoryServ.getProducts(product));
		model.addAttribute("unassignedCategories", categoryServ.notInProducts(product));
		return "redirect:/products/{productId}";
		
	}
	
	@GetMapping("/categories/{categoryId}")
	public String showCategory(@PathVariable("categoryId") Long id, Model model) {
		Category category = categoryServ.findCategoryId(id);
		model.addAttribute("category", category);
		model.addAttribute("assignedProducts", productServ.getCategories(category));
		model.addAttribute("unassignedProducts", productServ.notInCategories(category));
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{categoryId}")
	public String editCategory(@PathVariable("categoryId")Long id, 
			@RequestParam(value= "productId") Long productId, Model model) {
		Category category = categoryServ.findCategoryId(id);
		Product product = productServ.findProductId(productId);
		category.getProducts().add(product);
		categoryServ.updateCategory(category);
		model.addAttribute("assignedProducts", productServ.getCategories(category));
		model.addAttribute("unassignedProducts", productServ.notInCategories(category));
		return "redirect:/categories/{categoryId}";
		
	}
	
	
	
}
