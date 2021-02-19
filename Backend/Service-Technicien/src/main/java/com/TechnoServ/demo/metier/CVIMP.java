package com.TechnoServ.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.dao.CVrepository;
import com.TechnoServ.demo.entity.CV;
@Service
public class CVIMP implements CVmetier{
	@Autowired
	private CVrepository ur;
	@Override
	public void add(CV c) {
		// TODO Auto-generated method stub
		ur.save(c);
	}
}
