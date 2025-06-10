<%-- 
    Document   : UserDashboard
    Created on : Jun 3, 2025, 9:16:29 PM
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
            } else {
                User us = (User) session.getAttribute("user"); //ep kieu dtoUser nho import vao

                out.print("<h4>Welcome " + us.getName() + "comback</h4>");
                out.print("<p><a href = 'LogoutController'>Logout</a></p>");
                out.print("<p><a href = 'ViewProfile.jsp'>Change Profile</a></p>");

            }
        %>
    </body>
</html>
