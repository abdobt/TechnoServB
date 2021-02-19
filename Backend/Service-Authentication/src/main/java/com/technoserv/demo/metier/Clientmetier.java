package com.technoserv.demo.metier;


import java.util.List;

import com.technoserv.demo.entity.Client;

public interface Clientmetier {
	public Client add(Client a);
	public void delete(Client c);
	public Client update(Client c);
	public List<Client> afficher();
}
