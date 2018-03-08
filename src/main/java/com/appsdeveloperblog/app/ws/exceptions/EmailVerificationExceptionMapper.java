/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.exceptions;

import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessage;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author admin
 */
@Provider
public class EmailVerificationExceptionMapper implements ExceptionMapper<EmailVerificationException>{
    
       public Response toResponse(EmailVerificationException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
        ErrorMessages.EMAIL_ADDRESS_NOT_VERIFIED.name(),
        "www.google.com");
        
        return Response.status(Response.Status.FORBIDDEN).entity(errorMessage).build();
    }
}
