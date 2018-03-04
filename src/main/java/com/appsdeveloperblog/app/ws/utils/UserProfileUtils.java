/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.utils;

import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;

/**
 *
 * @author admin
 */
public class UserProfileUtils {
    public void validateRequiredFields(UserDTO userDto) throws MissingRequiredFieldException
    {
        if(userDto.getFirstName() == null ||
                userDto.getFirstName().isEmpty() ||
                userDto.getLastName() == null ||
                userDto.getLastName().isEmpty() ||
                userDto.getEmail() == null ||
                userDto.getEmail().isEmpty() ||
                userDto.getPassword() == null ||
                userDto.getPassword().length() < 6
                ) {
            throw new MissingRequiredFieldException(
                ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }
    }
}
