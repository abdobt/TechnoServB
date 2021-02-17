package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client extends User {
	protected String phone_num;
	private String ville;
	/*@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Demande> ldemande;*/
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(String phone_num, String ville) {
		super();
		this.phone_num = phone_num;
		this.ville = ville;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
}
