package com.lepremier.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepremier.api.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{

}
