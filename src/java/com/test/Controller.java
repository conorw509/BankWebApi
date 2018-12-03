/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author conor
 */
@Path("/controller")
public class Controller {
    //yes!

    @GET
   @Path("/getData")
 @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public ArrayList<testModel> getAllData() throws ClassNotFoundException, SQLException{
        
        ArrayList<testModel> arr = new ArrayList<>();
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/bank", "root", "Lola.1.2.3");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customers");
        while(rs.next()){
            testModel ts = new testModel();
            ts.setId(rs.getInt("id"));
            ts.setName(rs.getString("name"));
                   ts.setAddress(rs.getString("address"));
                          ts.setEmail(rs.getString("email"));
                             ts.setPassword(rs.getString("password"));
                             arr.add(ts);
                             
                          
            
            
        }
        
        return arr;
        
        
    }
}
