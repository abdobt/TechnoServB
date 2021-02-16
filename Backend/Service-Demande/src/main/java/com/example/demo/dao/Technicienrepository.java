package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Technicien;
import com.example.demo.entity.User;

public interface Technicienrepository extends JpaRepository<Technicien, String> {
	List<Technicien> findByVille(String Ville);

}
