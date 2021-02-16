package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Location;
import com.example.demo.entity.Technicien;
import com.example.demo.entity.User;
import com.example.demo.metier.TechnicienImp;

@RestController
public class serv {
	@Autowired
	private TechnicienImp imp;
	@PostMapping("/service1/wc")
	public String updatelocation(@RequestBody Location o)
	{ 
		System.out.println("location : "+o.getLattitude()+" , "+o.getLongitude());
		UserDetails principal =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Technicien t=imp.findbyemail(principal.getUsername());
        t.setLattitude(o.getLattitude());
        t.setLongitude(o.getLongitude());
        imp.update(t);
		System.out.println("lat : "+t.getLattitude());
		return "Welcome to abdo's page";
	}
	@PostMapping("/service1/update")
	public String updatestate()
	{
		UserDetails principal =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Technicien t=imp.findbyemail(principal.getUsername());
		t.setDisponible(!t.isDisponible());
		imp.update(t);
		return "update s";
	}
	@GetMapping("/service1/infos")
	public Technicien getinfos()
	{
		UserDetails principal =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Technicien t=imp.findbyemail(principal.getUsername());
		return t;
	}
}
