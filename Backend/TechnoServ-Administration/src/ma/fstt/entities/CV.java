package ma.fstt.entities;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CV {
	private int id;
private Blob doc;

public Blob getDoc() {
	return doc;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setDoc(Blob doc) {
	this.doc = doc;
}

public CV(int id,Blob doc) {
	super();
	this.id=id;
	this.doc = doc;
}
}