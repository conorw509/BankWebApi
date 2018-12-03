/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bank;


import com.project.bank.objects.customer;
import static com.sun.corba.se.impl.presentation.rmi.StubConnectImpl.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import static javax.management.remote.JMXConnectorFactory.connect;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static org.apache.tomcat.jni.Local.connect;

/**
 *
 * @author conor
 */
@Path("/customer")
public class customerResource {
    
    String url= "jdbc:derby://localhost:1527/bank";
String userN = "root";
String pWord = "Lola.1.2.3";
 Connection conn = null;
 int count = 0;

 
    @GET
   @Path("/getAllCustomers")
 @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public ArrayList<customer> getAllCustomers() throws ClassNotFoundException, SQLException{
        
        ArrayList<customer> arr = new ArrayList<>();
       
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection(url, userN, pWord);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customer");
        while(rs.next()){
            customer ts = new customer();
           //ts.setId(rs.getInt("id"));
            ts.setName(rs.getString("name"));
                   ts.setAddress(rs.getString("address"));
                          ts.setEmail(rs.getString("email"));
                             ts.setPassword(rs.getString("password"));
                             ts.setAccType(rs.getString("AccountType"));
                             arr.add(ts);    
            
        }
        
        return arr;     
    }
  
    @POST
   @Path("/addCustomer")
 @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
       public customer addCustomer(customer cust) throws SQLException, ClassNotFoundException{
                
          customer ts = new customer();
           String sql="insert into customers (name,address,email,password,AccountType) values(?,?,?,?,?)";
          
     
        Class.forName("org.apache.derby.jdbc.ClientDriver");
            
                  conn = DriverManager.getConnection(url, userN, pWord);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
      
           // ts.setId(rs.getInt("id"));
            ts.setName(rs.getString("name"));
                   ts.setAddress(rs.getString("address"));
                          ts.setEmail(rs.getString("email"));
                             ts.setPassword(rs.getString("password"));
                             ts.setAccType(rs.getString("AccountType"));
                           
                           
       }
            return ts;
       
}
       
}
