package com.example.demo.metier;

import java.util.List;


import com.example.demo.entity.Technicien;

public interface Technicienmetier {
	public Technicien add(Technicien a);
	public void delete(Technicien c);
	public Technicien update(Technicien c);
	public List<Technicien> afficher();
	public List<Technicien> findByVille(String Ville);
}
