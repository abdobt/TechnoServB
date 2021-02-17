package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Specialite;
import com.example.demo.entity.User;

public interface Specialiterepository extends JpaRepository<Specialite, String> {
	Specialite findByName(String name);

}
