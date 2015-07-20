package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
	private static Connection con;
	private final static String classe = "com.mysql.jdbc.Driver";
	private final static String urlBanco = "jdbc:mysql://127.0.0.1/gce";
	private final static String userBanco = "root";
	private final static String senhaBanco = "";
	
	public static Connection criar(){
		return criar(userBanco, senhaBanco);
	}
	
	public static Connection criar(String user, String pass) {
		try {
			Class.forName(classe);
			con = DriverManager.getConnection(urlBanco, userBanco, senhaBanco);
			if (con.getWarnings() != null)
				System.err.println(con.getWarnings());
		} catch (Exception e) {
			System.err.println(e);
		}
		return con;
	}
}
