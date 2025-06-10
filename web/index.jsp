<%-- 
    Document   : index
    Created on : Jun 3, 2025, 9:00:47 PM
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
        <div style="background:#999661; height:50px;padding: 20px; " >
            <a href="index.jsp">home</a>|<a href="Login.jsp">Login</a>
            <form action="SearchBookController" style="float:right">
                <input type="text" name="txtsearch" />
                <input type="submit" value="find"/>
            </form>
        </div>    
        <div style="float:left; width: 70%;">coming soon</div>    
        <div style="float:left; width: 30%; background: #ffffcc;">    
            <form action="RegisterController" method="post" style=" padding: 5%" >
                <p>name:<input type="text" name="txtname" required="">*</p>
                <p>email<input type="text" name="txtemail" required="">*</p>
                <p>password:<input type="password" name="txtpassword" required="">*</p>
                <p>confirm password:<input type="password" name="txtconfirmpassword" required="">*</p>
                <p><input type="submit" name="btn" value="submit"></p>
            </form>
        </div>   
    </body>
</html>
