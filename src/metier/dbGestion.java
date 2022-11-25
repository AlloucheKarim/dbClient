package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClientImpl;
import dao.Idao;



public class dbGestion {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*String BDD = "dbGestion";
		String url = "jdbc:mysql://localhost/" + BDD;
		String user = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		Connection conn = null;
		
		conn = DriverManager.getConnection(url, user, passwd);
	
		System.out.println("Connecté");
		
		String sql = "INSERT INTO client (id,nom,age,adresse) VALUES (?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1,3);
		ps.setString(2, "Alex");
		ps.setInt(3, 36);
		ps.setString(4,"alex@gmail.com");
		//int res = ps.executeUpdate();
		//System.out.println(res);
		
		Client client = new Client (5,"Karim",30,"karim@gmail.com");
		sql = "INSERT INTO client (id,nom,age,adresse) VALUES (?,?,?,?)";
		ps= conn.prepareStatement(sql);
		ps.setInt(1,client.getId());
		ps.setString(2, client.getNom());
		ps.setInt(3, client.getAge());
		ps.setString(4,client.getAdresse());
		int res = ps.executeUpdate();
		System.out.println(res);
		
		sql = "UPDATE client SET nom=?, age=?, adresse=? WHERE id=3";
		ps= conn.prepareStatement(sql);
		ps.setString(1, "Aleex");
		ps.setInt(2, 37);
		ps.setString(3,"aleex@gmail.com");
		res = ps.executeUpdate();
		System.out.println(res);

		sql = "SELECT * From client";
		ps= conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Client> listClient = new ArrayList<Client>();
		while(rs.next()) {
			int id= rs.getInt(1);
			String nom =rs.getString(2);
			int age = rs.getInt(3);
			String adresse = rs.getString(4);
			
			//System.out.println(id+"\t"+nom+"\t"+age+"\t"+adresse);
			Client client1 = new Client(id,nom,age,adresse);
			listClient.add(client1);
		}
		
		for(Client c: listClient) {
			System.out.println(c);
		}*/
		
		Idao<Client> dao = new ClientImpl();
		
		//Ajout un client
		Client client = new Client(6,"Adrien",24,"adriiien@gmail.com");
		//dao.add(client);
		
		//Update un client
		Client client1 = new Client(6,"Adrien",21,"adriiien@hotmail.com");
		//dao.update(client1);
		
		//Supprimer un client
		dao.delete(6);
		
		//Afficher un seul client
		Client c = dao.get(5);
		
		//Afficher tout les clients
		List<Client> l = dao.getAll();
		System.out.println(c);
		System.out.println(l);
		
	}

}
