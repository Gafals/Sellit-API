package com.lepremier.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepremier.api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
