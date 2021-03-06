package com.technoserv.demo.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoserv.demo.dao.Clientrepository;
import com.technoserv.demo.dao.Userrepository;
import com.technoserv.demo.entity.Client;

@Service
public class ClientImp implements Clientmetier {
	@Autowired
	private Clientrepository cr;
	@Override
	public Client add(Client a) {
		// TODO Auto-generated method stub
		return cr.save(a);
	}

	@Override
	public void delete(Client c) {
		// TODO Auto-generated method stub
		 cr.delete(c);
	}

	@Override
	public Client update(Client c) {
		// TODO Auto-generated method stub
		return cr.save(c);
	}

	@Override
	public List<Client> afficher() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

}
