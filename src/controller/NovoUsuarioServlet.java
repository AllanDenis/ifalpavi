package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;

@WebServlet(description = "Servlet para adicionar usuário", urlPatterns = { "/novo-usuario" })
public class NovoUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Usuario u = new Usuario();
		u.setUsuario(request.getParameter("usuario"));
		u.setSenha(request.getParameter("senha"));
		if (UsuarioDAO.salvar(u)) {
			System.out.println("[info] " + this.getClass().getName() + ": " + u.getNome()
				+ " usuário " + u.getUsuario() + " criado com sucesso.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			System.err.println("[erro] " + this.getClass().getName() + ": falha ao salvar usuário");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		out.close();
	}
}
