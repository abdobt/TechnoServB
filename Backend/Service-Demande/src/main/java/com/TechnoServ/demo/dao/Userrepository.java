package com.TechnoServ.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.entity.User;

public interface Userrepository  extends JpaRepository<User, String> {
	 User findByEmail(String email);
}
