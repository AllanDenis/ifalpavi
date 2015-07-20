package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {  
    public static boolean validate(String user,String pass){  
	    boolean status=false;
	    try{  
	    	Connection con = ConexaoFactory.criar(); 	          
		    PreparedStatement ps=con.prepareStatement(  
		    		"SELECT * FROM usuarios WHERE usuario=? AND senha=?");
		    ps.setString(1, user);  
		    ps.setString(2, pass);  
		    ResultSet rs=ps.executeQuery();  
		    System.err.println(ps.getWarnings());
		    status=rs.next();
	    }
	    catch(Exception e){System.out.println(e);}  
	    return status;  
    }  
}  