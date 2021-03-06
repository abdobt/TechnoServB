package com.TechnoServ.demo.metier;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.dao.Clientrepository;
import com.TechnoServ.demo.dao.Userrepository;
import com.TechnoServ.demo.entity.Client;
import com.TechnoServ.demo.entity.User;

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
	
	@Override
	public Client findbyemail(String email) {
		// TODO Auto-generated method stub
		return cr.findByEmail(email);
	}

}
