<%-- 
    Document   : verify-email
    Created on : Mar 8, 2018, 12:20:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.appsdeveloperblog.app.ws.service.UsersService"%>
<%@page import="com.appsdeveloperblog.app.ws.service.impl.UsersServiceImpl"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Email Verification Page</h1>

        <%
           String token = request.getParameter("token");
           UsersService usersService = new UsersServiceImpl();
           boolean isEmailVerified = usersService.verifyEmail(token);
           
           if(isEmailVerified)
           {
        %>
        <p>Thank you! Your email has been verified!</p>
        <%
            } else {
        %>
        <p>Sorry, your email address could not been verified this time or you've already used the verification link once.</p>
        <%
               
                   }

        %>                    

    </body>
</html>
