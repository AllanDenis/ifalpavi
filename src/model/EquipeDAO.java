package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Equipe;

public class EquipeDAO {
	public static Equipe e;

	private static Connection con;

	public static Equipe carrega(long id) {
		e = new Equipe();
		con = ConexaoFactory.criar();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM equipe WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.first())
				System.out.println("[erro] UsuarioDAO: Registro vazio.");
			if (rs.getWarnings() != null) {
				System.err.println(rs.getWarnings());
			}
			// Popula a instância com os dados do banco
			e.setNome(rs.getString("nome"));

			// Tudo ok
			e.setStatus(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return e;
	}
}
