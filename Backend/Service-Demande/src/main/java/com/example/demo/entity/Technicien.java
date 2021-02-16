package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="technicien")
public class Technicien extends User {
private float longitude;
private float lattitude;
private boolean disponible;
private int phone_number;
private String ville;

public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
@ManyToOne
@JoinColumn (name="id_specialite")
private Specialite specialite ;
@OneToMany
@JoinColumn(name="id_technicien")
private List<RDV> lrdv;

public Specialite getSpecialite() {
	return specialite;
}
public void setSpecialite(Specialite specialite) {
	this.specialite = specialite;
}
public List<RDV> getLrdv() {
	return lrdv;
}
public void setLrdv(List<RDV> lrdv) {
	this.lrdv = lrdv;
}

public Technicien() {
	super();
	// TODO Auto-generated constructor stub
}
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
public boolean isDisponible() {
	return disponible;
}
public void setDisponible(boolean disponible) {
	this.disponible = disponible;
}
public int getPhone_number() {
	return phone_number;
}
public void setPhone_number(int phone_number) {
	this.phone_number = phone_number;
}
}
