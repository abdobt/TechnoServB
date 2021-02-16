package com.example.demo.metier;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Userrepository;
import com.example.demo.entity.User;

@Service
public class UserImp implements UserDetailsService,Usermetier {
	@Autowired
	private Userrepository ur;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=ur.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
	
	@Override
		public User findbyemail(String email) {
			// TODO Auto-generated method stub
			return ur.findByEmail(email);
		}
}
