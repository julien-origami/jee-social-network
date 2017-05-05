package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.jcjTeam.theSocialNetwork.beans.User;

public class ConectionTool {

	public static void main(String[] args) {
		Connection con = ConectionTool.getConnection();
		if(con != null){
			System.out.println(con.toString());
			try{
				con.close();
			}	catch (SQLException e){
				e.printStackTrace();
			}
		}
		MessageDAO mdao = new MessageDAO();
		User user = new User();
		user.setId("ADMIN");
		System.out.println(mdao.getListOfMessages(user).toString());
	}
	
	public static Connection getConnection(){
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
			return con;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
