package com.technoserv.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoserv.demo.entity.Client;

public interface Clientrepository extends JpaRepository<Client, String>  {
}
