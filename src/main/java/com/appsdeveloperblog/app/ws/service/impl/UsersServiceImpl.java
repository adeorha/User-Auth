/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.exceptions.CouldNotCreateRecordException;
import com.appsdeveloperblog.app.ws.io.dao.DAO;
import com.appsdeveloperblog.app.ws.io.dao.impl.MySQLDAO;
import com.appsdeveloperblog.app.ws.service.UsersService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;
import com.appsdeveloperblog.app.ws.utils.UserProfileUtils;

/**
 *
 * @author admin
 */
public class UsersServiceImpl implements UsersService {

    DAO database;
    
    public UsersServiceImpl()
    {
        this.database = new MySQLDAO();
    }
    UserProfileUtils userProfileUtils = new UserProfileUtils();
    
    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO();
        
        //Validate the required fields
        userProfileUtils.validateRequiredFields(user);
        
        //Check if user already exists
        UserDTO existingUser = this.getUserByUserName(user.getEmail());
        if(existingUser != null)
        {
            throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
        }
        
        //Create an Entity object
        
        
        //Generated secure public user id
        String userId = userProfileUtils.generateUserId(30);
        user.setUserId(userId );
        
        //Generate salt
        
        
        //Generate secure password
        
        
        //Record data into a database
        
        
        //Return back the user profile
        
        return returnValue;
    }
    
    private UserDTO getUserByUserName(String userName)
    {
        UserDTO userDto = null;
        
        if(userName == null || userName.isEmpty()){
            return userDto;
        }
        
        //Connect to database
        try {
            this.database.openConnection();
            userDto = this.database.getUserByUserName(userName);
        } finally{
            this.database.closeConnection();
        }        
        return userDto;
    }
    
}
