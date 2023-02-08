package com.lepremier.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepremier.api.entities.Category;
import com.lepremier.api.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository userRepository;
	
	public List<Category> findAll() {
		return userRepository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = userRepository.findById(id);
		return obj.get();
	}

}
