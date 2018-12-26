package com.erojas.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {


private static  Connection connection;
	
	public static Connection conectar() {
		if(connection!=null) {
			return connection;
		}
		
		InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("properties/ds_config.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(inputStream);
			String driver = properties.getProperty("ds_driver");
			String url = properties.getProperty("ds_url");
			String username = properties.getProperty("ds_username");
			String password = properties.getProperty("ds_password");
			
			//Class.forName(driver);
			connection =DriverManager.getConnection(url, username, password);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
