package com.TechnoServ.demo.metier;

import java.util.List;

import com.TechnoServ.demo.entity.Technicien;


public interface Technicienmetier {
	public Technicien add(Technicien a);
	public void delete(Technicien c);
	public Technicien update(Technicien c);
	public List<Technicien> afficher();
	public Technicien findbyemail(String email);
}
