package controllers;

import dao.BookDAO;
import dto.Book;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;

//@WebServlet(name = "BookController", urlPatterns = {"/book"})
public class BookController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "search":
                searchBook(request, response);
                break;
            case "borrow":
                borrowBook(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }

    private void searchBook(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String findTitle = request.getParameter("txtsearch");
        if (findTitle != null && !findTitle.isEmpty()) {
            BookDAO d = new BookDAO();
            ArrayList<Book> list = d.getBooks(findTitle);
            request.setAttribute("RESULT", list);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.print("em yeu co");
            out.print("<a href='index.html'>home</a>");
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            String id = request.getParameter("txtid");
            Book b = null;
            if (id != null) {
                BookDAO d = new BookDAO();
                b = d.getBook(Integer.parseInt(id.trim()));
            }

            if (b != null) {
                HttpSession session = request.getSession();
                ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("CART");
                if (list == null) {
                    list = new ArrayList<>();
                }
                boolean found = false;
                for (Book book : list) {
                    if (book.getId() == b.getId()) {
                        found = true;
                        break;
                    }
                }
                if (!found) list.add(b);
                session.setAttribute("CART", list);
                request.getRequestDispatcher("book?action=search&txtsearch=").forward(request, response); // reload trang search
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}