/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.SystemConfigDAO;
import dto.ConfigSystem;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ConfigController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConfigController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfigController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        SystemConfigDAO d = new SystemConfigDAO();
        ArrayList<ConfigSystem> list = d.getAll();
        
        if(list != null && !list.isEmpty()){
            out.print("<table>");
            
            out.print("<tr>");
            out.print("<th> ID </th>");
            out.print("<th> CONFIG KEY </th>");
            out.print("<th> CONFIG VALUE </th>");
            out.print("<th> DESCRIPTION </th>");
            out.print("</tr>");
            
            for(ConfigSystem configSystem : list){
                out.print("<form>");
                out.print("<tr>");
                
                out.print("<td>" + configSystem.getId() + "</td>");
                out.print("<td>" + configSystem.getKey() + "</td>");
                out.print("<td>" + configSystem.getValue() + "</td>");
                out.print("<td>" + configSystem.getDescription() + "</td>");
                out.print("<td><input type = 'submit' value = 'edit'/></td>");
                
                out.print("</tr>");
                out.print("</form>");
            }
            
            out.print("</table>");
        }else {
            out.print("<p>No data</p>");
            out.print("<a href = 'AdminDashboard.html'>Admin Home</a>");
                   
        }
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
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
