package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client extends User {
	protected String phone_num;
	private String ville;
	@OneToMany
	@JoinColumn(name="id_client")
	protected List<Demande> ldemande;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public List<Demande> getLdemande() {
		return ldemande;
	}
	public void setLdemande(List<Demande> ldemande) {
		this.ldemande = ldemande;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
}
