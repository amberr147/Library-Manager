<%-- 
    Document   : viewcart
    Created on : Jun 11, 2025, 4:03:39 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList, dto.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>   
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
         <form action="SendBorrowRequestController">
                <input type="submit" value="submit borrow request"/>
         </form>        
        <%
          }
          else{
            out.print("your cart is empty");
          }
       %>
    </body>
</html>
