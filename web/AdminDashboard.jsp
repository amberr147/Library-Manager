<%-- 
    Document   : AdminDashboard
    Created on : May 31, 2025, 3:56:42 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="dto.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><%
            
             if(session.getAttribute("user")==null){
                 response.sendRedirect("index.jsp");
             }else{
                 User us=(User) session.getAttribute("user");                 
                 out.print("<h4>Welcome " + us.getName() +" comeback</h4>"); 
                 out.print("<p><a href='LogoutController'>logout</a></p>");
                 out.print("<p><a href='#'>change profile</a></p>");
                 out.print("<p><a href='#'>manage borrow request</a></p>");
                 
       
             } %>
    </body>
</html>
