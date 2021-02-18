package com.TechnoServ.demo.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.dao.Demanderepository;
import com.TechnoServ.demo.entity.Demande;

@Service
public class DemandeImp implements Demandemetier {
	
	@Autowired
	private Demanderepository dr;

	@Override
	public Demande add(Demande a) {
		// TODO Auto-generated method stub
		return dr.save(a);
	}

	@Override
	public void delete(Demande c) {
		// TODO Auto-generated method stub
		dr.delete(c);
		
	}

	@Override
	public Demande update(Demande c) {
		// TODO Auto-generated method stub
		return dr.save(c);
	}

	@Override
	public List<Demande> afficher() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}
	

}
