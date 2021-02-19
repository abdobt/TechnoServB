package ma.fstt.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.services.BaseDAO;
import ma.fstt.entities.Technicien;
import ma.fstt.entities.User;
@ApplicationScoped
public class TechnicienDAO extends BaseDAO<Technicien> {

	public TechnicienDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Technicien object)throws SQLException {
		
String sql = "insert into User (email ,name, password,ville) values (? ,?,?,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getEmail());
		this.preparedStatement.setString(2, object.getName());
		this.preparedStatement.setString(3, object.getPassword());
		this.preparedStatement.setString(4, object.getVille());
		
		this.preparedStatement.execute();
		
		User u = this.getUserByEmail(object.getEmail());
				
		String sql2 = "insert into technicien (phone_number, ville, id, id_specialite, email, name, password, disponible, lattitude, longitude) values (?,?,?,? ,?,?,?,?,?,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql2);
		
		// mapping objet relation
		
		this.preparedStatement.setBoolean(8, false);
		this.preparedStatement.setDouble(9, object.getLattitude());
		this.preparedStatement.setDouble(10, object.getLongitude());
		this.preparedStatement.setString(1, object.getPhone_num());
		this.preparedStatement.setString(2, object.getVille());
		this.preparedStatement.setLong(3, u.getId());
		this.preparedStatement.setLong(4, object.getId_specialite());
		this.preparedStatement.setString(5, object.getEmail());
		this.preparedStatement.setString(6, object.getName());
		this.preparedStatement.setString(7, object.getPassword());
		
		this.preparedStatement.execute();
		
		
		
	}

	@Override
	public void update(Technicien object)throws SQLException {
		
String sql = "update  Technicien set  phone_number =? , ville= ?, id_specialite= ? , email= ?, name= ? , password= ? where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
//		this.preparedStatement.setBoolean(1, object.isDisponible());
//		this.preparedStatement.setDouble(2, object.getLattitude());
//		this.preparedStatement.setDouble(3, object.getLongitude());
		this.preparedStatement.setString(1, object.getPhone_num());
		this.preparedStatement.setString(2, object.getVille());
		this.preparedStatement.setLong(3, object.getId_specialite());
		this.preparedStatement.setString(4, object.getEmail());
		this.preparedStatement.setString(5, object.getName());
		this.preparedStatement.setString(6, object.getPassword());
		this.preparedStatement.setLong(7, object.getId());
		
		this.preparedStatement.execute();
		
		
String sql2 = "update  User set  email= ?, name= ? , password= ? , ville= ? where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql2);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getEmail());
		this.preparedStatement.setString(2, object.getName());
		this.preparedStatement.setString(3, object.getPassword());
		this.preparedStatement.setString(4, object.getVille());
		this.preparedStatement.setLong(5, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public void delete(Technicien object)throws SQLException {
				
		
		String sql = "delete  from User  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1, object.getId());
		
		this.preparedStatement.execute();
		
		String sql2 = "delete  from Technicien  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql2);
		
		// mapping objet relation

		this.preparedStatement.setLong(1, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public java.util.List<Technicien> List() throws SQLException{
		
		java.util.List<Technicien> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet =     this.statement.executeQuery("Select * from Technicien ");
		
		while(this.resultSet.next()) {
			list.add(new Technicien(this.resultSet.getBoolean(1), this.resultSet.getDouble(2),this.resultSet.getDouble(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getLong(6),this.resultSet.getLong(7), this.resultSet.getString(8), this.resultSet.getString(9), this.resultSet.getString(10) )) ;
		}
		return list;
	}

	@Override
	public Technicien getById(Long id)throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select *  from Technicien  where id = ?";
		
		Technicien et  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			et = new Technicien(this.resultSet.getBoolean(1), this.resultSet.getDouble(2),this.resultSet.getDouble(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getLong(6),this.resultSet.getLong(7), this.resultSet.getString(8), this.resultSet.getString(9), this.resultSet.getString(10));
			
			break ;
			
		}
		
		
		return et ;
	}
	
	public User getUserByEmail(String email)throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select *  from User  where email = ?";
		
		User et  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setString(1,email);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			et = new User(this.resultSet.getLong(1), this.resultSet.getString(2),this.resultSet.getString(3),this.resultSet.getString(4),this.resultSet.getString(5));
			
			break ;
			
		}
		
		
		return et ;
	}

}
