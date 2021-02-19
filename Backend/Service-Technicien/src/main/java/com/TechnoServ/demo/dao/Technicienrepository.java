package com.TechnoServ.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechnoServ.demo.entity.Technicien;


public interface Technicienrepository extends JpaRepository<Technicien, String> {
	Technicien findByEmail(String email);
}
