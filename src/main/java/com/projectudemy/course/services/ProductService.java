package com.projectudemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectudemy.course.entities.Product;
import com.projectudemy.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository ProductRepository;
	
	public List<Product> findAll() {
		return ProductRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> objProduct = ProductRepository.findById(id);
		return objProduct.get();
	}
	
}
