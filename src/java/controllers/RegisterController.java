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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class RegisterController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        String name=request.getParameter("txtname");
        String email=request.getParameter("txtemail");
        String password=request.getParameter("txtpassword");
        if(name!=null && email!=null && password!=null){
             //check email co trong bang Users
             UserDAO d=new UserDAO();
             User us=d.getUserByEmail(email);
             if(us!=null){
                 out.print("<h1>duplicate email</h1>");
                 out.print("<p><a href='index.html'>home</a></p>");
             }else{
                 //insert vao bang User
                 int result=d.insertNewUser(name, email, password);
                 if(result>=1){
                      out.print("<h1>inserted!!! ban co the login</h1>");
                      out.print("<p><a href='index.html'>home</a></p>");
                 }else{
                      out.print("<h1>not insert</h1>");
                      out.print("<p><a href='index.html'>home</a></p>");
                 }
             }
        }
        
        
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
