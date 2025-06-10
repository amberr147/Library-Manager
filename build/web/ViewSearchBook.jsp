<%-- 
    Document   : ViewSearchBook
    Created on : Jun 3, 2025, 9:40:04 PM
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
        <% //nho import thu vien
            // Lấy danh sách kết quả tìm kiếm
            ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("BOOK_RESULT");
            
            // Kiểm tra kết quả
            if (list != null && !list.isEmpty()) {
                for (Book book : list) {
                    out.print("<div style='width:200px; height:350px; margin:15px; padding:10px; border:1px solid #ccc; border-radius:8px; display:inline-block; vertical-align:top; text-align:center; '>");
                    out.print("<form>");
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
            } else {
                out.print("<h3>Not found</h3>");
                out.print("<a href='index.jsp'>Home</a>");
            }

        %>
    </body>
</html>
