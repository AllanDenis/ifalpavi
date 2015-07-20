package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	private static Usuario u;
	private static Connection con;

	public static Usuario carrega(String user, String pass) {
		u = new Usuario();
		con = ConexaoFactory.criar();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
				System.out.println("fudeu");
			if (rs.getWarnings() != null) {
				System.err.println(rs.getWarnings());
			}
			// Popula a instância com os dados do banco
			u.setNome(rs.getString("nome"));
			
			// Tudo ok
			u.setStatus(true);
			u.setUsuario(user);
			u.setSenha(pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
