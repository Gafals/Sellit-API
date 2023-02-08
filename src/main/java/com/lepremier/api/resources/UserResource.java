package com.lepremier.api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lepremier.api.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> getUser() {
		User user = new User(1, "gabriel", "gabriel@mail.com", "9999", "123");
		return ResponseEntity.ok().body(user);
	}
	
}
