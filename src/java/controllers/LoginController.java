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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class LoginController extends HttpServlet {
   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       response.setCharacterEncoding("utf-8");
       out.print("<html><body>");
       String email=request.getParameter("txtemail");
       String password=request.getParameter("txtpassword");
       if(email!=null && password!=null){
           UserDAO d=new UserDAO();
           User us=d.getUser(email, password);
           if(us!=null){
              //tinh nang : welcome, view cart, view history ,shopping cart,request borrow, change profile.... : coming soon
              //luu us object vao session cua client vi can no cho cac tinh nang tiep theo
              HttpSession s=request.getSession();
              s.setAttribute("user", us);
              
              if(us.getRole().equalsIgnoreCase("admin")){
                  response.sendRedirect("AdminDashboard.jsp");
              }
              else{
                  response.sendRedirect("UserDashboard.jsp");
              }
               
           }else{
              request.setAttribute("ERROR","email or password is invalid");
              request.getRequestDispatcher("Login.jsp").forward(request, response);
           }
       }
       out.print("</body></html>");
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
