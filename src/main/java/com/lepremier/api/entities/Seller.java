package com.lepremier.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lepremier.api.entities.dtos.SellerDTO;
import com.lepremier.api.entities.enums.Perfil;

@Entity
public class Seller extends User {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	public Seller() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Seller(Integer id, String name, String cpf, String email, String phone, String password) {
		super(id, name, cpf, email, phone, password);
		addPerfil(Perfil.CLIENTE);
	}
	
	public Seller(SellerDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.perfis = obj.getPerfis();
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
