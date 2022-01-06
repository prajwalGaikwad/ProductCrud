package com.work.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work.demo.model.Category;
import com.work.demo.model.Product;
import com.work.demo.service.CategoryService;
import com.work.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
	 @Autowired
	 private ProductService ps;
	 
	 @Autowired
	 private CategoryService cs;
	 
	 
	 
	 @PostMapping("/create")
	 public Product createProduct(@RequestBody Product product) {
		 return ps.saveProduct(product);
	 }
	 
	 @GetMapping("/find")
	 public Product findProduct(@RequestParam Integer productId) {
		 return ps.findProductById(productId);
	 }
	 
	 @GetMapping("/findAllProducts")
	 public List<Product> findAllProduct(@RequestParam(value="page",defaultValue= "0") int page,
			 								@RequestParam(value="limit",defaultValue= "10") int limit) {
		 return ps.findAll(page, limit);
	 }
	 	 
	 @GetMapping("/delete")
	 public String deleteProductById(@RequestParam Integer productId) {
		 String deleteProductRecord = ps.deleteProductRecord(productId);
		 return deleteProductRecord;
	 }
	 
	 @PostMapping("/update")
	 public Product updateProduct(@RequestBody Product product) {
		 return ps.updateRecord(product);
	 }
	 
	 
	 @PostMapping("/create-category")
	 public Category createCategory(@RequestBody Category category) {
		 return cs.create(category);
	 }
	
	 @GetMapping("/findcategoryId")
	 public Category findcategory(@RequestParam Integer categoryId) {
		 return cs.getCategory(categoryId);
	 }
	 
	 @GetMapping("/findAllCategories")
	 public List<Category> findAllCategory(@RequestParam(value="page",defaultValue= "0") int page,
			 								@RequestParam(value="limit",defaultValue= "10") int limit) {
		 return cs.findAll(page, limit);
	 }
	 
	 
	 @GetMapping("/deletecategoryId")
	 public String deletecategory(@RequestParam Integer categoryId) {
		 String deleteCategory = cs.delete(categoryId);
		 return deleteCategory;
	 }
	 
	 @PostMapping("/updateCategory")
	 public Category updateCategory(@RequestBody Category category) {
		 return cs.update(category);
	 }
	 
}

