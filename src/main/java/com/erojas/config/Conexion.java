package com.erojas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


private static  Connection connection;
	
	public static Connection conectar() {
		if(connection!=null) {
			return connection;
		}
		

		
		try {
			
			String driver ="org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost:5432/spring-xml-jc";
			String username =  "postgres";
			String password = "123";
			
			//Class.forName(driver);
			connection =DriverManager.getConnection(url, username, password);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	public Connection cerrarConexion() {
		if(connection==null) {
			return connection;
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
