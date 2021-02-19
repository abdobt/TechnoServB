package com.TechnoServ.demo.metier;

import java.util.List;

import com.TechnoServ.demo.entity.Specialite;
import com.TechnoServ.demo.entity.User;

public interface Specialitemetier {
	
	public Specialite add(Specialite a);
	public void delete(Specialite c);
	public Specialite update(Specialite c);
	public List<Specialite> afficher();
	public Specialite  findByName(String name);

}
