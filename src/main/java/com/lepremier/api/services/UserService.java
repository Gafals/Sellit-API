//package com.lepremier.api.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.persistence.EntityNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import com.lepremier.api.entities.User;
//import com.lepremier.api.entities.dtos.UserDTO;
//import com.lepremier.api.repositories.UserRepository;
//import com.lepremier.api.services.exceptions.DatabaseException;
//import com.lepremier.api.services.exceptions.ResourceNotFoundException;
//
//@Service
//public class UserService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	public List<User> findAll() {
//		return userRepository.findAll();
//	}
//	
//	public User findById(Integer id) {
//		Optional<User> obj = userRepository.findById(id);
//		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
//	}
//	
//	public User userCreate(UserDTO objDTO) {
//		objDTO.setId(null);
//		User newObj = new User(objDTO);
//		return userRepository.save(newObj);
//	}
//	
//	public void userDelete(Integer id) {
//		try {			
//			userRepository.deleteById(id);
//		} catch (EmptyResultDataAccessException e) {
//			throw new ResourceNotFoundException(id);
//		} catch (DataIntegrityViolationException r) {
//			throw new DatabaseException(r.getMessage());
//		}
//	}
//	
//	public User userUpdate(Integer id, User obj) {
//		try {
//			User entity = userRepository.getOne(id);
//			updateData(entity, obj);
//			return userRepository.save(entity);
//		} catch (EntityNotFoundException e) {
//			throw new ResourceNotFoundException(id);
//		}
//	}
//
//	private void updateData(User entity, User obj) {
//		entity.setName(obj.getName());
//		entity.setEmail(obj.getEmail());
//		entity.setPhone(obj.getPhone());
//	}
//
//}
