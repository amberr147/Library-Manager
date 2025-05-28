package view;

import dto.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ViewSearchBook extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            // Lấy danh sách kết quả tìm kiếm
            ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("result");

            // Bắt đầu HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");
            out.println("</head>");
            out.println("<body>");

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
                        out.print("<br/><a href='index.html'>Quay lại</a>");
                    }

                    out.print("</form>");
                    out.print("</div>");
                }
            } else {
                out.print("<h3>Not found</h3>");
                out.print("<a href='index.html'>Home</a>");
            }

            // Kết thúc HTML
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
