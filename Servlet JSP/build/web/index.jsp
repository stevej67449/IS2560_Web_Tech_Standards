

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conference Manager</title>
        
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" href="style.css" type="text/css">


        
    </head>
    <body>
        <div class="center">
         
            <h1>Conference Attendance Manager</h1>
        
            <form action="ListServlet" method="POST">
                <input class="button" type="submit" value="Show List" />
            </form> 
            <br><br>
            <form action="newAttendee.jsp" method="POST">
                <input class="button2" type="submit" value="Add New Attendee" />
            </form> 
            
        </div>
            
    </body>
</html>
