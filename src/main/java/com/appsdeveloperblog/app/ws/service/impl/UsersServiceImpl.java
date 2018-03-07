/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.exceptions.CouldNotCreateRecordException;
import com.appsdeveloperblog.app.ws.exceptions.NoRecordFoundException;
import com.appsdeveloperblog.app.ws.io.dao.DAO;
import com.appsdeveloperblog.app.ws.io.dao.impl.MySQLDAO;
import com.appsdeveloperblog.app.ws.service.UsersService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;
import com.appsdeveloperblog.app.ws.utils.UserProfileUtils;
import java.util.List;

/**
 *
 * @author admin
 */
public class UsersServiceImpl implements UsersService {

    DAO database;

    public UsersServiceImpl() {
        this.database = new MySQLDAO();
    }
    UserProfileUtils userProfileUtils = new UserProfileUtils();

    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO();

        //Validate the required fields
        userProfileUtils.validateRequiredFields(user);

        //Check if user already exists
        UserDTO existingUser = this.getUserByUserName(user.getEmail());
        if (existingUser != null) {
            throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
        }

        //Create an Entity object
        //Generated secure public user id
        String userId = userProfileUtils.generateUserId(30);
        user.setUserId(userId);

        //Generate salt
        String salt = userProfileUtils.getSalt(30);

        //Generate secure password
        String encryptedPassword = userProfileUtils.generateSecurePassword(user.getPassword(), salt);
        user.setSalt(salt);
        user.setEncryptedPassword(encryptedPassword);

        //Record data into a database
        returnValue = this.saveUser(user);

        //Return back the user profile
        return returnValue;
    }

    public UserDTO getUser(String id) {
        UserDTO returnValue = null;
        try {
            this.database.openConnection();
            returnValue = this.database.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        } finally {
            this.database.closeConnection();
        }

        return returnValue;
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        UserDTO userDto = null;

        if (userName == null || userName.isEmpty()) {
            return userDto;
        }

        //Connect to database
        try {
            this.database.openConnection();
            userDto = this.database.getUserByUserName(userName);
        } finally {
            this.database.closeConnection();
        }
        return userDto;
    }

    private UserDTO saveUser(UserDTO user) {
        UserDTO returnValue = null;
        //Connect to database
        try {
            this.database.openConnection();
            returnValue = this.database.saveUser(user);
        } finally {
            this.database.closeConnection();
        }
        return returnValue;
    }

    public List<UserDTO> getUsers(int start, int limit) {
        List<UserDTO> users = null;
        
        try {
            this.database.openConnection();
            users = this.database.getUsers(start, limit);
        } finally {
            this.database.closeConnection();
        }
        
        return users;
    }

}
