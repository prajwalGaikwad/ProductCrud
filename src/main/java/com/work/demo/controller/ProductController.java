package com.work.demo.controller;

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
	 public String createProduct(@RequestBody Product product) {
		 String response= ps.saveProduct(product);
		 return response;
	 }
	 
	 @GetMapping("/find")
	 public String findProduct(@RequestParam Integer productId) {
		 return ps.findProductById(productId);
	 }
	 
	 
	 @GetMapping("/delete")
	 public String deleteProductById(@RequestParam Integer productId) {
		 String deleteProductRecord = ps.deleteProductRecord(productId);
		 return deleteProductRecord;
	 }
	 
	 @PostMapping("/update")
	 public String updateProduct(@RequestBody Product product) {
		 String response= ps.updateRecord(product);
		 return response;
	 }
	 
	 
	 @PostMapping("/create-category")
	 public String createCategory(@RequestBody Category category) {
		 System.out.println(category);
		 return cs.create(category);
	 }
	
	 @GetMapping("/findcategoryId")
	 public String findcategory(@RequestParam Integer categoryId) {
		 return cs.getCategory(categoryId);
	 }
	 
	 
	 @GetMapping("/deletecategoryId")
	 public String deletecategory(@RequestParam Integer categoryId) {
		 String deleteCategory = cs.delete(categoryId);
		 return deleteCategory;
	 }
	 
	 @PostMapping("/updateCategory")
	 public String updateCategory(@RequestBody Category category) {
		 String response= cs.update(category);
		 return response;
	 }
}

