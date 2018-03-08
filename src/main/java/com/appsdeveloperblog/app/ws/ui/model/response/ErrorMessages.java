/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.ui.model.response;

/**
 *
 * @author admin
 */
public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field. Please check the documentation for the required fields."),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    NO_RECORD_FOUND("The given record was not found"),
    AUTHENTICATION_FAILED("The username or password was incorrect"),
    COULD_NOT_UPDATE_RECORD("Could not update the record"),
    COULD_NOT_DELETE_RECORD("Could not delete the record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address wasn't verified");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
