<%-- 
    Document   : index
    Created on : Jun 3, 2025, 9:00:47 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<%@page import ="dto.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="background:#999661; height:50px;padding: 20px; " >
            <a href="index.jsp">home</a>|<a href="Login.jsp">Login</a>
            <a href="viewcart.jsp">view cart</a>
            <form action="SearchBookController" style="float:right">
                <input type="text" name="txtsearch" value="<%= (request.getParameter("txtsearch")!=null)?request.getParameter("txtsearch"):"" %>"/>
                <input type="submit" value="find"/>
            </form>
        </div>   

        <div style="float:left; width: 70%;">
            <!-- comment -->
            <% //nho import thu vien
            // Lấy danh sách kết quả tìm kiếm
            ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("BOOK_RESULT");
            
            // Kiểm tra kết quả
            if (list != null && !list.isEmpty()) {
                for (Book book : list) {
                    out.print("<div style='width:200px; height:350px; margin:15px; padding:10px; border:1px solid #ccc; border-radius:8px; display:inline-block; vertical-align:top; text-align:center; '>");
                    out.print("<form action='BorrowController'>");
                    out.print("<input type='hidden' name='txtid' value='"+book.getId()+"' />");
                    out.print("<input type='hidden' name='txtsearch' value='"+request.getParameter("txtsearch")+"' />");
                    out.print("<img src='" + book.getUrl() + "' width='150' height='150' />");
                    out.print("<br/>ID: " + book.getId());
                    out.print("<br/>Title: " + book.getTitle());
                    out.print("<br/>Category: " + book.getCategory());
                    out.print("<br/>Available Copy: " + book.getAvailable_copies());

                    if (book.getAvailable_copies() > 0) {
                        out.print("<br/><input type='submit' value='Request Borrow'/><br/>");
                    } else {
                        out.print("<br/><b>Chưa có</b>");
                        out.print("<br/><a href='index.jsp'>Quay lại</a>");
                    }

                    out.print("</form>");
                    out.print("</div>");
                }
            }

            %>
            <!<!-- comment -->
        </div> 


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
