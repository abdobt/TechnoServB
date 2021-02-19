package com.TechnoServ.demo.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.dao.Specialiterepository;
import com.TechnoServ.demo.entity.Specialite;

@Service
public class Specialiteimpl implements Specialitemetier {
	@Autowired
	private Specialiterepository sr;

	@Override
	public Specialite add(Specialite a) {
		// TODO Auto-generated method stub
		return sr.save(a);
	}

	@Override
	public void delete(Specialite c) {
		// TODO Auto-generated method stub
		sr.delete(c);
	}

	@Override
	public Specialite update(Specialite c) {
		// TODO Auto-generated method stub
		return sr.save(c);
	}

	@Override
	public List<Specialite> afficher() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Specialite findByName(String name) {
		// TODO Auto-generated method stub
		return sr.findByName(name);
	}

}
