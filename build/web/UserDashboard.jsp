<%-- 
    Document   : UserDashboard
    Created on : May 31, 2025, 3:57:05 PM
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
    <body>
        <jsp:include page="header.jsp"/>
        <%
            
             if(session.getAttribute("user")==null){
                 response.sendRedirect("index.jsp");
             }else{
                 User us=(User) session.getAttribute("user");                 
                 out.print("<h4>Welcome " + us.getName() +" comeback</h4>"); 
                 out.print("<p><a href='LogoutController'>logout</a></p>");
                 out.print("<p><a href='ViewProfile.jsp'>change profile</a></p>");
                 out.print("<p><a href='#'>view borrow request</a>");
       
             } %>
    </body>
</html>
