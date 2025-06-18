<%-- 
    Document   : ViewProfile
    Created on : May 31, 2025, 4:25:14 PM
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
        <%
         if(session.getAttribute("user")==null){
                 response.sendRedirect("index.jsp");
             }
         else{
             User us=(User)session.getAttribute("user");
         %>   
        <h1>Profile</h1>
        <form action="ChangeProfileController" method="post">
            <p>name:<input type="text" name="txtname" value="<%= us.getName() %>" required=""/>*</p>
            <p>email:<input type="text"  value="<%= us.getEmail() %>" readonly=""/></p> 
            <p>password:<input type="password" name="txtpassword" value="<%= us.getPassword() %>" required=""/>*</p>
            <p>role:<input type="text"  value="<%= us.getRole() %>" readonly=""/></p>
            <p>status:<input type="text"  value="<%= us.getStatus() %>" readonly=""/></p>
            <p><input type="submit"  value="save" /></p>            
        </form>
        <%} %>
    </body>
</html>
