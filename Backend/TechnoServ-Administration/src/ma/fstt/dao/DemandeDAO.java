package ma.fstt.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Demande;
import ma.fstt.entities.Technicien;
import ma.fstt.services.BaseDAO;
@ApplicationScoped
public class DemandeDAO extends BaseDAO<Demande>  {

	public DemandeDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(Demande object) throws SQLException {
		String sql = "insert into demande (adresse, lattitude, longitude, id_client, id_specialite, rating) values (?, ?, ?, ?, ? ,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getAdresse());
		this.preparedStatement.setDouble(2,0.0);
		this.preparedStatement.setDouble(3,0.0);
		this.preparedStatement.setLong(4, object.getId_client());
		this.preparedStatement.setLong(5, object.getId_specialite());
		this.preparedStatement.setDouble(6, object.getRating());


		
		this.preparedStatement.execute();
		
	}

	@Override
	public void update(Demande object) throws SQLException {
		
		String sql = "update  demande set adresse = ?, id_client = ? , id_specialite = ?, rating = ?  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		this.preparedStatement.setString(1, object.getAdresse());
		this.preparedStatement.setLong(2, object.getId_client());
		this.preparedStatement.setLong(3, object.getId_specialite());
		this.preparedStatement.setDouble(4, object.getRating());
		this.preparedStatement.setLong(5, object.getId());
		
		this.preparedStatement.execute();		
	}

	@Override
	public void delete(Demande object) throws SQLException {
		
		String sql = "delete  from demande  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1, object.getId());
		
		this.preparedStatement.execute();
		
		sql = "delete  from RDV  where id_demande = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1, object.getId());
		
		this.preparedStatement.execute();

		
	}
	
	@Override
	public java.util.List<Demande> List() throws SQLException {
		
		java.util.List<Demande> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet = this.statement.executeQuery("SELECT * from demande");
		
		while(this.resultSet.next()) {
			
			list.add(new Demande(this.resultSet.getLong(1), this.resultSet.getString(2), this.resultSet.getDouble(3), this.resultSet.getDouble(4), this.resultSet.getLong(5), this.resultSet.getLong(6), this.resultSet.getDouble(7))) ;
			
		}
		
		
		return list;

	}

	@Override
	public Demande getById(Long id) throws SQLException {
		String sql = "select *  from demande  where id = ?";
		
		Demande commande  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			commande = new Demande(this.resultSet.getLong(1), this.resultSet.getString(2), this.resultSet.getDouble(3), this.resultSet.getDouble(4), this.resultSet.getLong(5), this.resultSet.getLong(6), this.resultSet.getDouble(7));
			
			break ;
			
		}
		
		
		return commande ;

	}
	
}
