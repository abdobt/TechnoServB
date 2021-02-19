package ma.fstt.entities;

public class RDV {
	
	private Long id;
	private Long id_demande;
	private Long technicien;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_demande() {
		return id_demande;
	}
	public void setId_demande(Long id_demande) {
		this.id_demande = id_demande;
	}
	public Long getTechnicien() {
		return technicien;
	}
	public void setTechnicien(Long technicien) {
		this.technicien = technicien;
	}
	public RDV(Long id_demande, Long technicien) {
		super();
		this.id_demande = id_demande;
		this.technicien = technicien;
	}
	public RDV() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
