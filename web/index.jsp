<%-- 
    Document   : index
    Created on : May 31, 2025, 3:46:30 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList,dto.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/> 
        <div style="float:left; width: 70%;">
         <!-- cho nay de xuat kq tim kiem -->   
           <%
             ArrayList<Book> list=(ArrayList<Book>) request.getAttribute("RESULT");
           
            //xuat ket qua tim kiem(list)
            if(list!=null && !list.isEmpty()){
                for (Book book : list) {
                    out.print("<div style='float:left;margin:1%'>");
                    out.print("<form action='BorrowController'>");
                    out.print("<input type='hidden' name='txtid' value='"+book.getId()+"' />");
                    out.print("<input type='hidden' name='txtsearch' value='"+request.getParameter("txtsearch")+"' />");
                    out.print("<img src='"+ book.getUrl() +"'   />");
                    out.print("<br/>id:" + book.getId());
                    out.print("<br/>title:" + book.getTitle());
                    out.print("<br/>category:" + book.getCategory());
                    out.print("<br/>available copy:" + book.getAvailable_copies());
                    if(book.getAvailable_copies()>0){
                        out.print("<br/><input type='submit' value='request borrow' /> ");
                    }
                    out.print("</form>");
                    out.print("</div>");
                }
            }
            else{
                out.print("<h3>not found</h3>");
               
            }
           
           %> 
            
          <!-- het xuat tim kiem-->  
        </div>    
    <div style="float:left; width: 30%; background: #ffffcc;">    
        <form action="RegisterController" style=" padding: 5%"  method="post">
            <p>name:<input type="text" name="txtname" required="">*</p>
            <p>email<input type="text" name="txtemail" required="" >*</p>
            <p>password:<input type="password" name="txtpassword" required="">*</p>
            <p>confirm password:<input type="password" name="txtconfirmpassword" required="">*</p>
            <p><input type="submit" name="btn" value="submit"></p>
        </form>
      </div>   
           <jsp:include page="footer.jsp"/>
    </body>
</html>
