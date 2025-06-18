<%-- 
    Document   : Login
    Created on : May 31, 2025, 3:47:44 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="LoginController" method="post">
            <p><input type="text" name="txtemail"/>*</p>
            <p><input type="password" name="txtpassword"/>*</p>
            <p><input type="submit" value="login"/></p>
        </form>
        <p><%
            if( request.getAttribute("ERROR")!=null){
                 out.print( request.getAttribute("ERROR"));
            }
            %></p>
        
    </body>
</html>
