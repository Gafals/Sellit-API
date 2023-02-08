package com.lepremier.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepremier.api.entities.Product;
import com.lepremier.api.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository userRepository;
	
	public List<Product> findAll() {
		return userRepository.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> obj = userRepository.findById(id);
		return obj.get();
	}

}
