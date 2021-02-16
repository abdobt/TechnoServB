package com.example.demo.metier;

import java.util.List;


import com.example.demo.entity.Demande;

public interface Demandemetier {
	
	public Demande add(Demande a);
	public void delete(Demande c);
	public Demande update(Demande c);
	public List<Demande> afficher();

}
