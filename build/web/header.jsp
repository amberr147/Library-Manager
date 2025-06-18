<%-- 
    Document   : header
    Created on : Jun 18, 2025, 3:24:46 PM
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
    <div style="background:#999661; height:50px;padding: 20px; " >
    <a href="index.jsp">home</a>|<a href="Login.jsp">Login</a>
    | <a href="viewcart.jsp"> view cart</a>
    <form action="SearchBookController" style="float:right">
            <input type="text" name="txtsearch" value="<%= (request.getParameter("txtsearch")!=null)?request.getParameter("txtsearch"):"" %>" />
            <input type="submit" value="find"/>
    </form>
    </div>   
    </body>
</html>
