/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.BorrowRequestDAO;
import dto.Book;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author user
 */
@WebServlet(name="SendBorrowRequestController", urlPatterns={"/SendBorrowRequestController"})
public class SendBorrowRequestController extends HttpServlet {
   
   public void processRequest(HttpServletRequest request, HttpServletResponse response){
     try{
         HttpSession session=request.getSession();
         User us=(User) session.getAttribute("user");
         ArrayList<Book> list=(ArrayList<Book>) session.getAttribute("CART");
         if(us!=null && list!=null){
             BorrowRequestDAO d=new BorrowRequestDAO();
             int rs=d.insertBorrowRequest(us.getId(), list);
             if(rs>=1){
                 //xoa cart trong session
                 session.removeAttribute("CART");
                 request.getRequestDispatcher("index.jsp").forward(request, response);
             }
         }
         
     }catch(Exception e){
         e.printStackTrace();
     }
   }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request,response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          processRequest(request,response);
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
