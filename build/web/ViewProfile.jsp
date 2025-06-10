<%-- 
    Document   : ViewProfile
    Created on : Jun 3, 2025, 10:18:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "dto.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            } 
            else {
                User us = (User)session.getAttribute("user");
        %>
        <h1>Profile</h1>
        <form action="ChangeProfileController" method="post">
            <p>Name: <input type="text" name = "txtname" value = "<%= us.getName() %>" required=""/>*</p>
            <p>Email: <input type="text" value = "<%= us.getEmail() %>" readonly=""/></p>
            <p>Password: <input type="password" name = "txtpassword" value = "<%= us.getPassword() %>" required=""/>*</p>
            <p>Role: <input type="text" value = "<%= us.getRole() %>" readonly=""/></p>
            <p>Status: <input type="text" value = "<%= us.getStatus() %>" readonly=""/></p>
            <p><input type="submit" value = "save"/></p>
        </form>
        <% } %>
    </body>
</html>
