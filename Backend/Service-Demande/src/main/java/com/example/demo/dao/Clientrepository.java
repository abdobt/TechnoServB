package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Client;
import com.example.demo.entity.User;

public interface Clientrepository extends JpaRepository<Client, String>  {
	Client findByEmail(String email);
}
