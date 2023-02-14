package com.lepremier.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lepremier.api.entities.Seller;
import com.lepremier.api.entities.User;
import com.lepremier.api.entities.dtos.SellerDTO;
import com.lepremier.api.repositories.SellerRepository;
import com.lepremier.api.repositories.UserRepository;
import com.lepremier.api.services.exceptions.ResourceNotFoundException;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Seller findById(Integer id) {
		Optional<Seller> obj = sellerRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Seller> findAll() {
		return sellerRepository.findAll();
	}

	public Seller create(SellerDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		Seller newObj = new Seller(objDTO);
		return sellerRepository.save(newObj);
	}

	public Seller update(Integer id, @Valid SellerDTO objDTO) {
		objDTO.setId(id);
		Seller oldObj = findById(id);
		
		if(!objDTO.getPassword().equals(oldObj.getPassword())) 
			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		
		validaPorCpfEEmail(objDTO);
		oldObj = new Seller(objDTO);
		return sellerRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Seller obj = findById(id);

		if (obj.getOrders().size() > 0) {
			throw new DataIntegrityViolationException("Seller possui ordens de serviço e não pode ser deletado!");
		}

		sellerRepository.deleteById(id);
	}

	private void validaPorCpfEEmail(SellerDTO objDTO) {
		Optional<User> obj = userRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		obj = userRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
