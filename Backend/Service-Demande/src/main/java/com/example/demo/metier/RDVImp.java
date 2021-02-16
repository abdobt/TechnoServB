package com.example.demo.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RDVrepository;
import com.example.demo.entity.RDV;

@Service
public class RDVImp implements RDVmetier {
	
	@Autowired
	private RDVrepository rr;

	@Override
	public RDV add(RDV a) {
		// TODO Auto-generated method stub
		return rr.save(a);
	}

	@Override
	public void delete(RDV c) {
		// TODO Auto-generated method stub
		rr.delete(c);
	}

	@Override
	public RDV update(RDV c) {
		// TODO Auto-generated method stub
		return rr.save(c);
	}

	@Override
	public List<RDV> afficher() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}
	
	

}
