<%-- 
    Document   : footer
    Created on : Jun 18, 2025, 4:55:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BookDAO"%>
<%@page import="dto.Book"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width: 100%;">
        <%
        ArrayList<Book> list=(ArrayList<Book>)request.getAttribute("RESULTAD");
        if(list!=null && !list.isEmpty()){
        for(Book book:list){%>
        <div>
            <a href="BookDetailController?bookid=<%=book.getId()%>"><img src='<%=book.getUrl()%>' style="width:50px;"></a>
            
        </div>
        <%
            }
            }
        %>
         </div>
    </body>
</html>
