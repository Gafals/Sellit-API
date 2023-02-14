package com.lepremier.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lepremier.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByCpf(String cpf);
	Optional<User> findByEmail(String email);

}
