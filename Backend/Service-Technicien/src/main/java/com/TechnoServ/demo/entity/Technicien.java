package com.TechnoServ.demo.entity;

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
private double longitude;
private double lattitude;
private boolean disponible;
private int phone_number;
private String ville;
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
/*@OneToOne
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
public double getLongitude() {
	return longitude;
}
public void setLongitude(float longitude) {
	this.longitude = longitude;
}
public double getLattitude() {
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
