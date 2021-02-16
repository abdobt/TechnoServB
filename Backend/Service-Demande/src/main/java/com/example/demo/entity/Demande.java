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
@Table
public class Demande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique = true)
	private Long id;
	
	private String adresse;
	
	private float longitude;
	
	private float lattitude;
	

	@ManyToOne
	@JoinColumn (name="id_specialite")
	private Specialite specialite ;
	
//	@OneToOne
//	@JoinColumn(name="id_rdv")
//	private RDV rdv;
	
	@ManyToOne
	@JoinColumn (name="id_client")
	private Client client ;
	
	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLattitude() {
		return lattitude;
	}

	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}

	
	public Demande(Long id, String adresse, Specialite specialite, RDV rdv, Client client) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.specialite = specialite;
//		this.rdv = rdv;
		this.client = client;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

//	public RDV getRdv() {
//		return rdv;
//	}
//
//	public void setRdv(RDV rdv) {
//		this.rdv = rdv;
//	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Demande(Long id, String adresse) {
		super();
		this.id = id;
		this.adresse = adresse;
	}

	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
