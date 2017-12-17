
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

        
        <jsp:useBean id="myBean" scope="page" class="is2560.AddServlet" />
        
        <jsp:setProperty name="myBean" property="firstname" />
        <jsp:setProperty name="myBean" property="lastname" />
        <jsp:setProperty name="myBean" property="email" />
        
        <h1>
            
            <jsp:getProperty name="myBean" property="firstname" /> 
            <jsp:getProperty name="myBean" property="lastname" />
            successfully added to the conference list.
        
        </h1>
            <div class="center">  
        <%
            int a = myBean.store();
            
            if (a==1) {
                out.print("Update Complete!");
            } else {
                out.print("Update Failed!");
            }
        %>
        <br>
        <br>
        <a href="newAttendee.jsp">Add another person.</a>
        <br>
        <br>
        <a href="ListServlet">View Attendee List</a>
         </div>     
    </body>
</html>
