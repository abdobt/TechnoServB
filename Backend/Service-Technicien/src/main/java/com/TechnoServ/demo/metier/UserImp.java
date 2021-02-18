package com.TechnoServ.demo.metier;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TechnoServ.demo.dao.Userrepository;
import com.TechnoServ.demo.entity.User;





@Service
public class UserImp implements UserDetailsService{
	@Autowired
	private Userrepository ur;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("email : "+email);
		User user=ur.findByEmail(email);
		System.out.println(user.getName());
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}
