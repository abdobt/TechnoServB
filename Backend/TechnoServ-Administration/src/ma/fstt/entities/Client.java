package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Client {
private Long id;
private String email;
private String name;
private String password;
private String ville;
private String phone_num;
private String adresse;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getPhone_num() {
	return phone_num;
}
public void setPhone_num(String phone_num) {
	this.phone_num = phone_num;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public Client(String phone_num, String ville, Long id, String email, String name, String password, String adresse) {
	super();
	this.id=id;
	this.email = email;
	this.name = name;
	this.password = password;
	this.ville = ville;
	this.phone_num = phone_num;
	this.adresse = adresse;
}
public Client() {
	super();
	// TODO Auto-generated constructor stub
}




}

