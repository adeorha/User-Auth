/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.exceptions;

/**
 *
 * @author admin
 */
public class CouldNotDeleteRecordException extends RuntimeException{

    private static final long serialVersionUID = 7681125764798498256L;
    
    public CouldNotDeleteRecordException(String message)
    {
        super(message);
    }
    
}
