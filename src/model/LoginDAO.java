package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {  
    public static boolean validate(String user,String pass){  
	    boolean status=false;  
	    try{  
	    	Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/gce", "root", ""); 	          
		    PreparedStatement ps=con.prepareStatement(  
		    "select * from usuarios where usuario=? and senha=?");  
		    ps.setString(1,user);  
		    ps.setString(2,pass);  
		          
		    ResultSet rs=ps.executeQuery();  
		    System.err.println(ps.getWarnings());
		    status=rs.next();  
	              
	    }
	    catch(Exception e){System.out.println(e);}  
	    return status;  
    }  
}  