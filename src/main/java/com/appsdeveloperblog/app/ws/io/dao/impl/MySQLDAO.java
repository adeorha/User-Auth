/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.io.dao.impl;

import com.appsdeveloperblog.app.ws.io.dao.DAO;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author admin
 */
public class MySQLDAO implements DAO{

    Session session;
    
    public void openConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserDTO getUserByUserName(String userName) {
        UserDTO userDto = null;
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        
        //Create Criteria against a particular persistent class
        CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);
        
        //Query roots always reference entity
        Root<UserEntity> profileRoot = criteria.from(UserEntity.class);
        criteria.select(profileRoot);
        criteria.where(cb.equal(profileRoot.get("email"), userName));
        
        //Fetch single result
        Query<UserEntity> query = session.createQuery(criteria);
        List<UserEntity> resultList = query.getResultList();
        if(resultList!= null && resultList.size() > 0)
        {
            UserEntity userEntity = resultList.get(0);
            userDto = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDto);
        }
        
        return userDto;
    }

    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
