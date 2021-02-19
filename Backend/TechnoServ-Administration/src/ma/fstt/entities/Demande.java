package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Demande {
	private Long id;
	private String adresse;
	private Double lattitude;
	private Double longitude;
	private Long id_client;
	private Long id_specialite;
	private Double rating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public Long getId_client() {
		return id_client;
	}
	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}
	public Long getId_specialite() {
		return id_specialite;
	}
	public void setId_specialite(Long id_specialite) {
		this.id_specialite = id_specialite;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Demande( Long id, String adresse, Double lattitude, Double longitude, Long id_client, Long id_specialite,
			Double rating) {
		super();
		this.id=id;
		this.adresse = adresse;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.id_client = id_client;
		this.id_specialite = id_specialite;
		this.rating = rating;
	}
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
