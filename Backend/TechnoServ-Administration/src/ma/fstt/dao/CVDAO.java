package ma.fstt.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ma.fstt.entities.CV;
import ma.fstt.entities.Client;
import ma.fstt.entities.Demande;
import ma.fstt.services.BaseDAO;

public class CVDAO extends BaseDAO<CV>{

	public CVDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(CV object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CV object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CV object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public java.util.List<CV> List() throws SQLException {
		// TODO Auto-generated method stub
		java.util.List<CV> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet = this.statement.executeQuery("SELECT * from cv");
		
		while(this.resultSet.next()) {
			
			list.add(new CV(this.resultSet.getInt(1),this.resultSet.getBlob("doc"))) ;		
		}	
		return list;
	}
	@Override
	public CV getById(Long id) throws SQLException {
		String sql = "select * from cv where id = ?";
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		CV cv = null;
		
		while(this.resultSet.next()) {
			
			
			cv = new CV(this.resultSet.getInt(1), this.resultSet.getBlob(2));
			
			break ;
			
		}
		return cv;
	}
	
}
