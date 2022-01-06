package com.work.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.demo.model.Product;
import com.work.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;

	public String saveProduct(Product p) {
		Product product = pr.save(p);
		return product.toString();
	}

	public String findProductById(Integer productId) {
		Optional<Product> findById = pr.findById(productId);

		if (findById.isPresent()) {
			return findById.get().toString();
		}
		return "Product not found ! for id:" + productId;

	}

	public String deleteProductRecord(Integer productId) {
		try {
			pr.deleteById(productId);
		} catch (Exception e) {
			return "product is not exist for id :" + productId;
		}

		return "product is deleted for :" + productId;
	}

	public String updateRecord(Product product) {
		Optional<Product> findById = pr.findById(product.getProductId());
		if (findById.isPresent()) {
			pr.save(product);
			return " record is updated";
		} else {
			return "record not exist for this id :" + product.getProductId() + " which you want to update !";
		}

	}

}
