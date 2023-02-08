package com.lepremier.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepremier.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
