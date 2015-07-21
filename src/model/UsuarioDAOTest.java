package model;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Usuario;

public class UsuarioDAOTest {

	@Test
	public void test() {
		Usuario u = new Usuario("sem nome", "allan", "123");
		u = UsuarioDAO.carregar(u.getUsuario(), u.getSenha());
		assertTrue(u.getStatus());
		assertTrue(u.getNome() == "Allan Denis");
		assertTrue(UsuarioDAO.salvar(u));
//		fail("Não implementado.");
	}

}
