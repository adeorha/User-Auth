/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.app.ws.utils;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.appsdeveloperblog.app.ws.exceptions.EmailVerificationException;
import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;

/**
 *
 * @author admin
 */
public class AmazonSES {

    final String FROM = "aditya.deorha1@gmail.com";

    final String SUBJECT = "One last step to complete your registration with PhotoApp";

    // The HTML body for the email.
    final String HTMLBODY = "<h1>Please verify your email address</h1>"
            + "<p>Thank you for registering with our mobile app. To complete registration process and be able to log in,"
            + " click on the following link: "
            + "<a href='ec2-18-188-30-205.us-east-2.compute.amazonaws.com/verify-email.jsp?token=$tokenValue'>"
            + "Final step to complete your registration"
            + "</a><br/><br/>"
            + "Thank you! And we are waiting for you inside!";

    // The email body for recipients with non-HTML email clients.
    final String TEXTBODY = "Please verify your email address. "
            + "Thank you for registering with our mobile app. To complete registration process and be able to log in,"
            + " open then the following URL in your browser window: "
            + " ec2-18-188-30-205.us-east-2.compute.amazonaws.com/verify-email.jsp?token=$tokenValue"
            + " Thank you! And we are waiting for you inside!";

    

  public void verifyEmail(UserDTO userDto)
  {
      try {
      AmazonSimpleEmailService client = 
          AmazonSimpleEmailServiceClientBuilder.standard()
            .withCredentials(new ProfileCredentialsProvider())
            .withRegion(Regions.US_WEST_2).build();
      
      String htmlBodyWithToken = HTMLBODY.replace("$tokenValue", userDto.getEmailVerificationToken());
      String textBodyWithToken = TEXTBODY.replace("$tokenValue", userDto.getEmailVerificationToken());
      
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses( userDto.getEmail() ) )
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(htmlBodyWithToken))
                  .withText(new Content()
                      .withCharset("UTF-8").withData(textBodyWithToken)))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(SUBJECT)))
          .withSource(FROM);

      client.sendEmail(request);
      
      System.out.println("Email sent!");
      
    } catch (Exception ex) {
        throw new EmailVerificationException(ex.getMessage());

    }
  }
  
  
 public static void main(String[] args)
  {
      UserDTO userDto = new UserDTO();
      userDto.setEmail("anchu.khanna@gmail.com");
      userDto.setEmailVerificationToken("fhf736djslfi4823kj");
      new AmazonSES().verifyEmail(userDto);
  }
  
}