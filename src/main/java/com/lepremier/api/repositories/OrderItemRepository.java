package com.lepremier.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepremier.api.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
