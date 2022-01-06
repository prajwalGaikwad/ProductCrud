package com.work.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.demo.model.Category;
import com.work.demo.model.Product;
import com.work.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public String create(Category category) {
		Category newcategory = categoryRepo.save(category);
		return newcategory.toString();
	}
	
	
	public String getCategory(Integer categoryId) {
		Optional<Category> findById = categoryRepo.findById(categoryId);
		if(findById.isPresent()) {
		  Category category = findById.get();
		  return category.toString();
		}
		return "product list not found for this category id :"+categoryId;
	}
	
	public String delete(Integer categoryId) {
		try {
			categoryRepo.deleteById(categoryId);
		} catch (Exception e) {
			return "product is not exist for id :" + categoryId;
		}

		return "product is deleted for :" + categoryId;
	}
	
	public String update(Category category) {
		Optional<Category> findById = categoryRepo.findById(category.getCategoryId());
		if (findById.isPresent()) {
			categoryRepo.save(category);
			return " record is updated";
		} else {
			return "record not exist for this id :" + category.getCategoryId() + " which you want to update !";
		}

	}
}
