<%-- 
    Document   : edit
    Created on : Nov 13, 2017, 10:17:07 AM
    Author     : Steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Information</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>

        
        <jsp:useBean id="myBean" class="is2560.EditServlet" />
        
        <jsp:setProperty name="myBean" property="firstname" />
        <jsp:setProperty name="myBean" property="lastname" />
        <jsp:setProperty name="myBean" property="email" />
        <jsp:setProperty name="myBean" property="updateID" />
        
        <h1>
            Editing Information
             
        </h1>
            
        <form action="update.jsp" method="POST">
            <h3>First Name:</h3>
            <input type="text" name="firstname" value='<jsp:getProperty name="myBean" property="firstname" />'  required/>
            
            <h3>Last Name:</h3>
             <input type="text" name="lastname" value='<jsp:getProperty name="myBean" property="lastname" />' required/>
            
            <h3>Email:</h3>
             <input type="email" name="email" value='<jsp:getProperty name="myBean" property="email" />' required />
             
             <br><br>
             
             <input type="submit" value="Update" />   
        </form>
             
             <br>
             <br>
             
             <a href="ListServlet">Return to Attendance List</a>     
            
            
    </body>
</html>
