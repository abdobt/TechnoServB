package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.text.Document;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.sql.Blob;
import java.sql.SQLException;

import com.example.demo.entity.CV;
import com.example.demo.entity.Location;
import com.example.demo.entity.Technicien;
import com.example.demo.entity.User;
import com.example.demo.metier.CVIMP;
import com.example.demo.metier.TechnicienImp;

@RestController
public class serv {
	@Autowired
	private TechnicienImp imp;
	@Autowired
	private CVIMP cvimp;
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
	@PostMapping("/service1/cv")
	public String depos(@RequestParam("file") MultipartFile file) throws SerialException, SQLException, IOException
	{
		System.out.println(file);
        CV c=new CV();
        Blob fileBlob = new javax.sql.rowset.serial.SerialBlob(file.getBytes());
       c.setDoc(fileBlob);
        cvimp.add(c);
		return "helllo";
	}
	private byte[] getByteArrayFromFile(final Document handledDocument) throws IOException {
	    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	   
	    return baos.toByteArray();
	}
}
