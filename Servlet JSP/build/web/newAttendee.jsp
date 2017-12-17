

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Attendee</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Add a New Attendee</h1>
        <div class="center">
            <form action="add.jsp" method="POST">
            <h3 class="left">First Name:</h3>
            <input type="text" name="firstname"  required/>
            
            <h3 class="left">Last Name:</h3>
             <input type="text" name="lastname" required/>
            
            <h3 class="left">Email:</h3>
             <input type="email" name="email" required />
             
             <br><br>
    

            <input class="button" type="submit" value="Create New Entry" />   
            </form>
            <br>
            <br>
            <form action="index.jsp" method="POST">
            <input class="button2" type="submit" value="Cancel" /> 
        </form>
        </div>
        
    </body>
</html>
