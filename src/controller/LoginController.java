package controller;

import java.io.IOException;
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginDAO;

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("usuario");  
	    String p=request.getParameter("senha");
	    
	    if(LoginDAO.validate(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Senha Incorreta");  
	        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
}
