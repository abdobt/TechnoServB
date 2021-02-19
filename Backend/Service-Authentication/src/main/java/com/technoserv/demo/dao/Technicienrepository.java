package com.technoserv.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoserv.demo.entity.Technicien;

public interface Technicienrepository extends JpaRepository<Technicien, String> {

}
