package com.technoserv.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Technicien extends User {
	
private float longitude;
private float lattitude;
private boolean disponible;
private int phone_number;
private String ville;

public Technicien(float longitude, float lattitude, boolean disponible, int phone_number, String ville) {
	super();
	this.longitude = longitude;
	this.lattitude = lattitude;
	this.disponible = disponible;
	this.phone_number = phone_number;
	this.ville = ville;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
/*@ManyToOne
@JoinColumn (name="id_service")
private Service service ;*/
/*@OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
private List<RDV> lrdv;*/
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
