package com.lepremier.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lepremier.api.entities.Seller;
import com.lepremier.api.entities.dtos.SellerDTO;
import com.lepremier.api.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerResource {

	@Autowired
	private SellerService sellerService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> findById(@PathVariable Integer id) {
		Seller obj = sellerService.findById(id);
		return ResponseEntity.ok().body(new SellerDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<Seller> list = sellerService.findAll();
		List<SellerDTO> listDTO = list.stream().map(obj -> new SellerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<SellerDTO> create(@Valid @RequestBody SellerDTO objDTO) {
		Seller newObj = sellerService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> update(@PathVariable Integer id, @Valid @RequestBody SellerDTO objDTO) {
		Seller obj = sellerService.update(id, objDTO);
		return ResponseEntity.ok().body(new SellerDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> delete(@PathVariable Integer id) {
		sellerService.delete(id); 
		return ResponseEntity.noContent().build();
	}

	
}
