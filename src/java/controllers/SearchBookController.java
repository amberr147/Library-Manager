/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.BookDAO;
import dto.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class SearchBookController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setCharacterEncoding("utf-8");
        out.print("<html><body>");
        
        String findtitle=request.getParameter("txtsearch");
        if(findtitle!=null && !findtitle.isEmpty()){
            BookDAO d=new BookDAO();
            ArrayList<Book> list=d.getBooks(findtitle);
            //luu list vao request cua controller de transfer qua ViewSearchBook
            request.setAttribute("RESULT", list);
            //Tao cookie de luu sach
            Cookie c = new Cookie("quangcao", findtitle);
            c.setMaxAge(86400);
            response.addCookie(c); //Khong duoc cookie qua 20 lan
            
            //mo trang ViewSearchBook va sd chung request voi controller nay
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            out.print("em yeu co");
            out.print("<a href='index.jsp'>home</a>");
        }
        out.print("</body></html>");
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
