package controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.BookDAO;
import dto.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SearchBookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchBookController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchBookController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("uft-8");
        out.print("<html><body>");

        String findtitle = request.getParameter("txtsearch");
        if (findtitle != null) {
            BookDAO d = new BookDAO();
            ArrayList<Book> list = d.getBooks(findtitle, findtitle, findtitle);
            //luu list vao
            request.setAttribute("BOOK_RESULT", list);
            //mo trang viewbook
            request.getRequestDispatcher("ViewSearchBook.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        //search book title
//        PrintWriter out = response.getWriter();
//        response.setCharacterEncoding("utf-8");
//        String findTitle = request.getParameter("txtsearch");
//        out.print("<html><body>");
//        
//        if(findTitle != null && !findTitle.isEmpty()){
//            BookDAO d = new BookDAO();
//            ArrayList<Book> list = d.getBooks(findTitle, findTitle, findTitle);
//            //xuat ket qua tim kiem(list), xuat ra man hinh
//            if(list != null && !list.isEmpty()){
//                for(Book book: list){
//                    out.print("<div style='width:200px; height:350px; margin:15px; padding:10px; border:1px solid #ccc; border-radius:8px; display:inline-block; vertical-align:top; text-align:center; '>");
//                    out.print("<form>");
//                    
//                    out.print("<img src='" + book.getUrl() + "' style='width:150px; height:200px; object-fit:cover;'/>");
//                    out.print("<br/>Title: " + book.getTitle());
//                    out.print("<br/>Author: " + book.getAuthor());
//                    out.print("<br/>Categoty: " + book.getCategory());
//                    out.print("<br/> Available copy: " + book.getAvailable_copies());
//                    if(book.getAvailable_copies() > 0){
//                        out.print("<br/><input type = 'submit' value = 'request borrow'");
//                    }
//                    
//                    out.print("</form>");
//                    out.print("</div>");
//                } 
//            } else{
//                out.print("<h3> Not Found </h3>");
//                out.print("<a href = 'index.html'>Home</a>");
//            } 
//        } else{
//            out.print("em yeu co");
//            out.print("<a href = 'index.html'");
//        }
//        out.print("</html>/<body>");
//    } 
