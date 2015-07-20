package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet(description = "Controlador de login", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	          
	    String user=request.getParameter("usuario");  
	    String pass=request.getParameter("senha");
	    Usuario u = UsuarioDAO.carrega(user, pass);
	    if(u.getStatus() == true){  
	    	System.out.println("### " + this.getClass().getName() + ": " + u.getNome() + " logou com sucesso.");
	    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	        rd.forward(request,response);  
	    }  
	    else{  
	        System.err.println("### " + this.getClass().getName() + ": falha de login");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
}
