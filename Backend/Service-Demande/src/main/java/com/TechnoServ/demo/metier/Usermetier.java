package com.TechnoServ.demo.metier;

import com.TechnoServ.demo.entity.User;

public interface Usermetier  {
	public User  findbyemail(String email);
}
