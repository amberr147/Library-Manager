<%-- 
    Document   : AdminDashboard
    Created on : Jun 3, 2025, 9:16:02 PM
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
            //response.setCharacterEncoding("utf-8");
            //HttpSession s = request.getSession();  [ kh can lay session vi da dc ay san trong service ]
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            } else {
                User us = (User) session.getAttribute("user");  //ep kieu dtoUser nho import vao
                //PrintWriter out = response.getWriter(); Bo printWriter vi out co san trong service r, neu du se error
                //out.print("<html><body>");

                out.print("<h4>Welcome " + us.getName() + "comback</h4>");
                out.print("<p><a href = 'LogoutController'>Logout</a></p>");
                out.print("<p><a href = 'ViewProfile.jsp'>Change Profile</a></p>");

                //out.print("</body></html>");  [ da co body va html nen loai bo ]
            }
        %>
    </body>
</html>
