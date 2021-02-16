package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rdv")
public class RDV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique = true)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_demande")
	private Demande demande;
	
	@ManyToOne
	@JoinColumn (name="id_technicien")
	private Technicien technicien ;

	public Long getId() {
		return id;
	}

	public RDV(Long id, Demande demande, Technicien technicien) {
		super();
		this.id = id;
		this.demande = demande;
		this.technicien = technicien;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Technicien getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RDV(Long id) {
		super();
		this.id = id;
	}

	public RDV() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
