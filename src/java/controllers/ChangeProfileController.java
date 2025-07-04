/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name="ChangeProfileController", urlPatterns={"/ChangeProfileController"})
public class ChangeProfileController extends HttpServlet {
   
   public void processRequest(HttpServletRequest request, HttpServletResponse response){
       try{
           String name=request.getParameter("txtname");
           String password=request.getParameter("txtpassword");
           HttpSession session=request.getSession();
           User us=(User) session.getAttribute("user");
           int id=us.getId();
           UserDAO d=new UserDAO();
           int result=d.UpdateUser(id,name,password);
           if(result==1){
               response.sendRedirect("LogoutController");
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
