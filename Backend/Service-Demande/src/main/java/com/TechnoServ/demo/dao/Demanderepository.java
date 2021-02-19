package com.TechnoServ.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechnoServ.demo.entity.Demande;

	
public interface Demanderepository extends JpaRepository<Demande, String> {


}
