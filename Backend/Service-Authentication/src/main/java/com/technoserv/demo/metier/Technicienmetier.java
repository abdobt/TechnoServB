package com.technoserv.demo.metier;



import java.util.List;

import com.technoserv.demo.entity.Technicien;

public interface Technicienmetier {
	public Technicien add(Technicien a);
	public void delete(Technicien c);
	public Technicien update(Technicien c);
	public List<Technicien> afficher();
}
