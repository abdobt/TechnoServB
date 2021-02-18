package ma.fstt.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.services.BaseDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.User;
@ApplicationScoped
public class ClientDAO extends BaseDAO<Client>{

	public ClientDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Client object)throws SQLException {
		
		
		String sql = "insert into User (email ,name, password,ville) values (? ,?,?,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getEmail());
		this.preparedStatement.setString(2, object.getName());
		this.preparedStatement.setString(3, object.getPassword());
		this.preparedStatement.setString(4, object.getVille());
		
		this.preparedStatement.execute();
		
		User u = this.getUserByEmail(object.getEmail());
		
		String sql2 = "insert into Client (phone_num, ville, id, email, name, password, adresse) values (? ,?,?,?,?,?,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql2);
		
		// mapping objet relation
		
		this.preparedStatement.setString(1, object.getPhone_num());
		this.preparedStatement.setString(2, object.getVille());
		this.preparedStatement.setLong(3, u.getId());
		this.preparedStatement.setString(4, object.getEmail());
		this.preparedStatement.setString(5, object.getName());
		this.preparedStatement.setString(6, object.getPassword());
		this.preparedStatement.setString(7, object.getAdresse());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public void update(Client object)throws SQLException {
		
		String sql = "update  Client set phone_num =? , ville= ?, email= ?, name= ? , password= ? , adresse= ?  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation
		this.preparedStatement.setString(1, object.getPhone_num());
		this.preparedStatement.setString(2, object.getVille());
		this.preparedStatement.setString(3, object.getEmail());
		this.preparedStatement.setString(4, object.getName());
		this.preparedStatement.setString(5, object.getPassword());
		this.preparedStatement.setString(6, object.getAdresse());
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
	public void delete(Client object)throws SQLException {
	String sql = "delete  from User  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1, object.getId());
		
		this.preparedStatement.execute();
		
		String sql2 = "delete  from Client  where id = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql2);
		
		// mapping objet relation

		this.preparedStatement.setLong(1, object.getId());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public java.util.List<Client> List() throws SQLException{
		
		java.util.List<Client> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		this.resultSet =this.statement.executeQuery("Select * from Client ");
		
		while(this.resultSet.next()) {
			
			
			list.add(new Client(this.resultSet.getString(1), this.resultSet.getString(2),this.resultSet.getLong(3),this.resultSet.getString(4),this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7))) ;
			
		}
		return list;
	}

	@Override
	public Client getById(Long id)throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select *  from Client  where id = ?";
		
		Client et  = null ;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		// mapping objet relation

		this.preparedStatement.setLong(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		
		while(this.resultSet.next()) {
			
			
			et = new Client(this.resultSet.getString(1), this.resultSet.getString(2),this.resultSet.getLong(3),this.resultSet.getString(4),this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7));
			
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
