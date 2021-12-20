package br.com.videoaulazeni.exemploWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectaMysql {
	private static final String URL = "jdbc:mysql://localhost:3306/datarural?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String SENHA = "Tulioenable1*";
	
	public static Connection obterConexao() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USER, SENHA);
	}

}
