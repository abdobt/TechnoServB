package com.TechnoServ.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechnoServ.demo.entity.Technicien;
import com.TechnoServ.demo.entity.User;

public interface Technicienrepository extends JpaRepository<Technicien, String> {
	List<Technicien> findByVille(String Ville);

}
