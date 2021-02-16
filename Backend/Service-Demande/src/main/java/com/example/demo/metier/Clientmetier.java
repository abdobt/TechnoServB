package com.example.demo.metier;


import java.util.List;

import com.example.demo.entity.Client;
import com.example.demo.entity.User;

public interface Clientmetier {
	public Client add(Client a);
	public void delete(Client c);
	public Client update(Client c);
	public List<Client> afficher();
	public Client findbyemail(String email);
}
