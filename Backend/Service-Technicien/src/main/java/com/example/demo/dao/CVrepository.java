package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CV;

public interface CVrepository extends JpaRepository<CV, String>{

}
