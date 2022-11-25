package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Client;

public class ClientImpl implements Idao<Client>{
	
	//Configuration pour la base de donnée et la connexion
	public Connection connect() throws SQLException {
		String BDD = "dbGestion";
		String url = "jdbc:mysql://localhost/" + BDD;
		String user = "root";
		String passwd = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url, user, passwd);
		return conn;
	
	}
	@Override
	public Client get(int id) throws SQLException {
		Connection cn = connect();
		String sql = "SELECT * From client where id=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Client client = new Client();
		rs.next();
		client.setId(rs.getInt(1));
		client.setNom(rs.getString(2));
		client.setAge(rs.getInt(3));
		client.setAdresse(rs.getString(4));
		cn.close();
		return client;
		
	}

	@Override
	public List<Client> getAll() throws SQLException {
		Connection cn = connect();
		String sql = "SELECT * From client";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Client> listClient = new ArrayList<Client>();
		
		while(rs.next()) {
			Client client = new Client();
			client.setId(rs.getInt(1));
			client.setNom(rs.getString(2));
			client.setAge(rs.getInt(3));
			client.setAdresse(rs.getString(4));
			listClient.add(client);
		}
		cn.close();
		return listClient;

	}

	@Override
	public int add(Client client) throws SQLException {
		Connection cn = connect();
		String sql = "INSERT INTO client (id,nom,age,adresse) VALUES (?,?,?,?)";
		PreparedStatement ps= cn.prepareStatement(sql);
		ps.setInt(1,client.getId());
		ps.setString(2, client.getNom());
		ps.setInt(3, client.getAge());
		ps.setString(4,client.getAdresse());
		int res = ps.executeUpdate();
		cn.close();
		return res;
	}

	@Override
	public int update(Client client) throws SQLException {
		Connection cn = connect();
		String sql = "UPDATE client SET nom=?, age=?, adresse=? WHERE id=?";
		PreparedStatement ps= cn.prepareStatement(sql);
		ps.setString(1, client.getNom());
		ps.setInt(2, client.getAge());
		ps.setString(3,client.getAdresse());
		ps.setInt(4, client.getId());
		int res = ps.executeUpdate();
		cn.close();
		return res	;
	}

	@Override
	public int delete(int id) throws SQLException {
		Connection cn = connect();
		String sql = "DELETE From client where id=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		cn.close();
		return res;
	}
	
}
