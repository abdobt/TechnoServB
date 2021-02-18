package com.TechnoServ.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechnoServ.demo.entity.Specialite;
import com.TechnoServ.demo.entity.User;

public interface Specialiterepository extends JpaRepository<Specialite, String> {
	Specialite findByName(String name);

}
