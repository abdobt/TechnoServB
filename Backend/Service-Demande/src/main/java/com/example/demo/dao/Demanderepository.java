package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Demande;

	
public interface Demanderepository extends JpaRepository<Demande, String> {


}
