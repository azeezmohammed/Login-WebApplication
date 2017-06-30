package com.iberrylogin.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VerifyLogin {
    public static boolean validate(String name, String pass) {
        //This program validates the user id and password
    	boolean status = false;
        try{
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
    	PreparedStatement ps=con.prepareStatement("select * from login");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next()){
    		
    		if(name.equals(rs.getString(1))&&pass.equals(rs.getString(2))){
    			
    			status=true;
    			
    		}
    		
    	}
    	
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        return status;
            }
    
}