package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Technicien {
	private Long id;
	private String email;
	private String name;
	private String password;
	private String ville;
	private String phone_num;
	private Double lattitude;
	private Double longitude;
	private Long id_specialite;
	private boolean disponible;
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
	public Double getLattitude() {
		return lattitude;
	}
	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Long getId_specialite() {
		return id_specialite;
	}
	public void setId_specialite(Long id_specialite) {
		this.id_specialite = id_specialite;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Technicien(boolean disponible, Double lattitude, Double longitude, String phone_num, String ville, Long id,  Long id_specialite,  String email, String name, String password) {
		super();
		this.id=id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.ville = ville;
		this.phone_num = phone_num;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.id_specialite = id_specialite;
		this.disponible = disponible;
	}
	public Technicien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
