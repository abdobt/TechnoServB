package com.TechnoServ.demo.metier;


import java.util.List;

import com.TechnoServ.demo.entity.Client;
import com.TechnoServ.demo.entity.User;

public interface Clientmetier {
	public Client add(Client a);
	public void delete(Client c);
	public Client update(Client c);
	public List<Client> afficher();
	public Client findbyemail(String email);
}
