package com.work.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.work.demo.model.Category;
import com.work.demo.model.Product;
import com.work.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
	
	public Category getCategory(Integer categoryId) {
		Optional<Category> findById = categoryRepo.findById(categoryId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	public List<Category> findAll(int page, int limit) {
		if(page > 0) page = page-1;
		
		Pageable pageableRequest= PageRequest.of(page, limit);
		
		Page<Category> categoryPage = categoryRepo.findAll(pageableRequest);
		
		List<Category> categories = categoryPage.getContent();
		
		if(categories!=null && !categories.isEmpty()) {
		  return categories;
		}
		return categories;

	}
	
	public String delete(Integer categoryId) {
		try {
			categoryRepo.deleteById(categoryId);
		} catch (Exception e) {
			return "product is not exist for id :" + categoryId;
		}

		return "product is deleted for :" + categoryId;
	}
	
	public Category update(Category category) {
		Optional<Category> findById = categoryRepo.findById(category.getCategoryId());
		if (findById.isPresent()) {
			return  categoryRepo.save(category);
		} else {
			return null;
		}

	}
}
