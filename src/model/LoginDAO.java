package model;

import java.sql.*;  
      
public class LoginDAO {  
    public static boolean validate(String user,String pass){  
	    boolean status=false;  
	    try{  
	    	Class.forName("com.mysql.jdbc.Driver");  
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gce","root","");  
	          
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