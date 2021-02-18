package com.example.demo.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique = true)
	private int id;
	  private Blob doc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blob  getDoc() {
		return doc;
	}
	public void setDoc(Blob  doc) {
		this.doc = doc;
	}
	public CV() {
		super();
		// TODO Auto-generated constructor stub
	}
}
