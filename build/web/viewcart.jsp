<%-- 
    Document   : viewcart
    Created on : Jun 11, 2025, 4:04:35 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList, dto.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           ArrayList<Book> list=(ArrayList)session.getAttribute("CART");
           if(list!=null && !list.isEmpty()){
        %>
        <table>
            <%
                for(Book b:list){
            %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getTitle() %></td>
                <td><%= b.getAuthor() %></td>
                <td><a href="#">remove</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
          }
          else{
            out.print("your cart is empty");
          }
        %>
    </body>
</html>
