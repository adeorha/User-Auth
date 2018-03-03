/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.ui.entrypoints;

import com.appsdeveloperblog.app.ws.ui.model.request.CreateUserRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserProfileRest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author admin
 */
@Path("/users")
public class UsersEntryPoint {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserProfileRest createUser(CreateUserRequestModel requestObject){
        UserProfileRest returnValue = new UserProfileRest();
        
        return returnValue;
    }
}
