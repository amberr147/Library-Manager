/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class BorrowRequestDAO {
    public int insertBorrowRequest(int userid, ArrayList<Book> list) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                 cn.setAutoCommit(false);
                 for (Book book : list) {
                     int bookid=book.getId();
                     String day=new Date(System.currentTimeMillis()).toString();
                     String sql="insert book_requests values(?,?,?,?)";
                     PreparedStatement st=cn.prepareStatement(sql);
                     st.setInt(1, userid);
                     st.setInt(2, bookid);
                     st.setString(3, day);
                     st.setString(4,"pending");
                     rs=st.executeUpdate();
                 } 
                 cn.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {           
            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
