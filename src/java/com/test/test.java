/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.google.common.net.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author conor
 */
@Path("/test")
public class test {
    
    
    
    @GET
   @Path("/getData")
 @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public String getJsonData(){
        
        return"test";
    }
    
}
