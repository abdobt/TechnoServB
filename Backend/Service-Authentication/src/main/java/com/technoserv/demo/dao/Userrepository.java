package com.technoserv.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoserv.demo.entity.User;



public interface Userrepository  extends JpaRepository<User, String> {
	 User findByEmail(String email);
}
