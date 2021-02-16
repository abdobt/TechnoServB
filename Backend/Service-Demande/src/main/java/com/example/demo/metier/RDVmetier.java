package com.example.demo.metier;

import java.util.List;


import com.example.demo.entity.RDV;

public interface RDVmetier {
	
	public RDV add(RDV a);
	public void delete(RDV c);
	public RDV update(RDV c);
	public List<RDV> afficher();

}
