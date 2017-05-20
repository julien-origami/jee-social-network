package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionTool {
	
	private static Connection connection;

	public static void main(String[] args) {
		Connection con = ConnectionTool.getConnection();
		if(con != null){
			System.out.println(con.toString());
			try{
				con.close();
			}	catch (SQLException e){
				e.printStackTrace();
			}
		}
		/*MessageDAO mdao = new MessageDAO();
		User user = new User();
		user.setId("ADMIN");
		System.out.println(mdao.getListOfMessages(user).toString());*/
	}
	
	public static Connection getConnection(){
		if(connection==null){
			try{
				Class.forName("org.hsqldb.jdbcDriver");
				connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
