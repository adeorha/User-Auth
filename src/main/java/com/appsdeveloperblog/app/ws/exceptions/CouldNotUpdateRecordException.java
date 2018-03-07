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
public class CouldNotUpdateRecordException extends RuntimeException{

    private static final long serialVersionUID = 6044832191046714082L;
    
    public CouldNotUpdateRecordException(String message)
    {
        super(message);
    }
    
}
