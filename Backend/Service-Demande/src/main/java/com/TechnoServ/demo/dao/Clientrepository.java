package com.TechnoServ.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechnoServ.demo.entity.Client;
import com.TechnoServ.demo.entity.User;

public interface Clientrepository extends JpaRepository<Client, String>  {
	Client findByEmail(String email);
}
