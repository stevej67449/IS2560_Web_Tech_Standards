
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Record Results</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>

        
        <jsp:useBean id="myBean" scope="page" class="is2560.EditServlet" />
        
        <jsp:setProperty name="myBean" property="firstname" />
        <jsp:setProperty name="myBean" property="lastname" />
        <jsp:setProperty name="myBean" property="email" />
        
        <div class="center">
        <h1>
            The record for 
            <jsp:getProperty name="myBean" property="firstname" /> 
            <jsp:getProperty name="myBean" property="lastname" />
            was successfully updated.
        
        </h1>
            
        <br>
        <br>
        <a href="ListServlet">View Attendee List</a>
         </div>
            
        <%
            
           String a= request.getParameter("firstname"); 
           String b= request.getParameter("lastname");
           String c= request.getParameter("email");
           String d = request.getParameter("updateID");
           
           myBean.update(a,b,c,d);     
        %>
            
    </body>
</html>
