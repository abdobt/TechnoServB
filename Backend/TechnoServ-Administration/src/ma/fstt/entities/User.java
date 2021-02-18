package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class User {
	
	private Long id;
	private String email;
	private String name;
	private String password;
	private String ville;
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
	public User(Long id, String email, String name, String password, String ville) {
		super();
		this.id=id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.ville = ville;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
