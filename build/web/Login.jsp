<%-- 
    Document   : Login
    Created on : Jun 3, 2025, 9:02:04 PM
    Author     : DELL
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
            <p><input type="text" name="txtemail" required=""/>*</p>
            <p><input type="password" name="txtpassword" required=""/>*</p>
            <p><input type="submit" value="login"/></p>
        </form>

        <p> 
            <%  //data loi dc in vao day, bai thi pe chuc nang login
                if(request.getAttribute("ERROR") != null){
                    out.print(request.getAttribute("ERROR"));
                }
            %>
        </p>

    </body>
</html>
