package com.example.demo.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "specialite") 
public class Specialite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false, unique = true)
	private Long id;
	
	@Column(nullable=false, length =  255 )
	private String name;
	
	@OneToMany
	@JoinColumn(name="id_specialite")
	private List<Technicien> techniciens;
	
	@OneToMany
	@JoinColumn(name="id_specialte")
	private List<Demande> demandes;
	
	public Specialite(Long id, String name, List<Technicien> techniciens, List<Demande> demandes) {
		super();
		this.id = id;
		this.name = name;
		this.techniciens = techniciens;
		this.demandes = demandes;
	}

	public List<Technicien> getTechniciens() {
		return techniciens;
	}

	public void setTechniciens(List<Technicien> techniciens) {
		this.techniciens = techniciens;
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Specialite(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
