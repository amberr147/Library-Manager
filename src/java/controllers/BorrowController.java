/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.BookDAO;
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
@WebServlet(name="BorrowController", urlPatterns={"/BorrowController"})
public class BorrowController extends HttpServlet {
   
   public void processRequest(HttpServletRequest request, HttpServletResponse response){
     try{
        HttpSession session=request.getSession(); 
        User us=(User) session.getAttribute("user");
        if(us==null){
            request.setAttribute("ERROR", "Ban can login cho thao tac muon sach");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else{
            String id=request.getParameter("txtid");
            Book b=null;
            if(id!=null){
                BookDAO d=new BookDAO();
                b=d.getBook(Integer.parseInt(id.trim()));
            }
            if(b!=null){

                ArrayList<Book> list=(ArrayList<Book>) session.getAttribute("CART");
                if(list==null){
                    list=new ArrayList<>();
                    list.add(b);
                }else{
                    boolean found=false;
                    for(Book book: list){
                        if(book.getId()==b.getId())
                        {
                            found=true;
                            break;
                        }
                    }
                    if(!found) list.add(b);
                }
                session.setAttribute("CART",list);
                request.getRequestDispatcher("SearchBookController").forward(request, response);
            }
        }//ket thuc else
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
