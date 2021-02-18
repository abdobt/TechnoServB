package com.TechnoServ.demo.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.dao.Technicienrepository;
import com.TechnoServ.demo.entity.Technicien;

@Service
public class TechnicienImp implements Technicienmetier{
	@Autowired
	private Technicienrepository tr;
	@Override
	public Technicien add(Technicien a) {
		// TODO Auto-generated method stub
		return tr.save(a);
		}

	@Override
	public void delete(Technicien c) {
		// TODO Auto-generated method stub
		tr.delete(c);
	}

	@Override
	public Technicien update(Technicien c) {
		// TODO Auto-generated method stub
		return tr.save(c);
	}

	@Override
	public List<Technicien> afficher() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public List<Technicien> findByVille(String Ville) {
		// TODO Auto-generated method stub
		
		return tr.findByVille(Ville);
	}

}
