/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.service;

import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UsersService {
    UserDTO createUser(UserDTO user);
    UserDTO getUser(String id);
    UserDTO getUserByUserName(String userName);
    List<UserDTO> getUsers(int start, int limit);
    void updateUserDetails(UserDTO userDetails);
}
