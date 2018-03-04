/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.service.UsersService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;

/**
 *
 * @author admin
 */
public class UsersServiceImpl implements UsersService {

    UserProfileUtils userProfileUtils = newUserProfileUtils();
    
    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO();
        
        //Validate teh required fields
        
        
        //Check if user already exists
        
        
        //Create an Entity object
        
        
        //Generated secure public user id
        
        
        //Generate salt
        
        
        //Generate secure password
        
        
        //Record data into a database
        
        
        //Return back the user profile
        
        return returnValue;
    }
    
}
