package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Technicien;


public interface Technicienrepository extends JpaRepository<Technicien, String> {
	Technicien findByEmail(String email);
}