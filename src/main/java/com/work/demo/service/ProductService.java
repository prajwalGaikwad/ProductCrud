package com.work.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.work.demo.model.Product;
import com.work.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;

	public Product saveProduct(Product p) {
		Product product = pr.save(p);
		return product;
	}

	public Product  findProductById(Integer productId) {
		Optional<Product> findById = pr.findById(productId);

		if (findById.isPresent()) {
			return findById.get() ;
		}
		return null;

	}
	
	public List<Product> findAll(int page, int limit) {
		if(page > 0) page = page-1;
		
		Pageable pageableRequest= PageRequest.of(page, limit);
		
		Page<Product> productPage = pr.findAll(pageableRequest);
		
		List<Product> products = productPage.getContent();
		
		if(products!=null && !products.isEmpty()) {
		  return products;
		}
		return products;

	}

	public String deleteProductRecord(Integer productId) {
		try {
			pr.deleteById(productId);
		} catch (Exception e) {
			return "product is not exist for id :" + productId;
		}

		return "product is deleted for :" + productId;
	}

	public Product updateRecord(Product product) {
		Product returnObj = new Product();
		Optional<Product> findById = pr.findById(product.getProductId());
		if (findById.isPresent()) {
			returnObj=pr.save(product);
			return returnObj;
		} else {
			return returnObj;
		}

	}

}
