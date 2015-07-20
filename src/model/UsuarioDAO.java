package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

import controller.Usuario;

public class UsuarioDAO {
	private static Usuario u = new Usuario();
	private static Connection con;
	private static String sql;

	public static Usuario carregar(String user, String pass) {
		con = ConexaoFactory.criar();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (!rs.first())
				System.out.println("[erro] UsuarioDAO: Registro vazio.");
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
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return u;
	}
	
	public static boolean salvar(Usuario u){
		sql = "UPDATE usuarios  SET nome= ?, usuario=?, senha=? WHERE id = ?";
		con = ConexaoFactory.criar();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getUsuario());
			ps.setString(3, u.getSenha());
			ps.setLong(4, u.getId());
			
			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
