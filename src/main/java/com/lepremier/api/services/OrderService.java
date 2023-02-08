package com.lepremier.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepremier.api.entities.Order;
import com.lepremier.api.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository userRepository;
	
	public List<Order> findAll() {
		return userRepository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> obj = userRepository.findById(id);
		return obj.get();
	}

}
