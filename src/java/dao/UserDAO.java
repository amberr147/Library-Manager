/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class UserDAO {
    //ham nay de lay thong tin user dua vao email
    //input: email
    //output: User trung email
    public User getUserByEmail(String email){
        User result=null;
        Connection cn=null;
        try {
            //bc1: ket noi app voi sqlserver
            cn=DBUtils.getConnection();
            if(cn!=null){
                //bc 2: viet query va execute query
                String sql = "select [id],name,email,password,role,status\n"
                        + "from dbo.users\n"
                        + "where email='"+email+"'";
                Statement st=cn.createStatement();
                ResultSet table=st.executeQuery(sql);
                if(table!=null && table.next()){
                    //bc3: doc noi dung trong bien table
                    int id=table.getInt("id");
                    String name=table.getString("name");
                    //String email=table.getString("email");
                    String password=table.getString("password");
                    String role=table.getString("role");
                    String status=table.getString("status");
                    result=new User(id, name, email, password, role, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
               if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    //ham nay de insert a new user vao bang user
    public int insertNewUser(String name,String email, String password){
        int result=0;
         Connection cn=null;
        try {
            //bc1: ket noi app voi sqlserver
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql="insert dbo.users values(?,?,?,'user','active')";
                PreparedStatement st=cn.prepareStatement(sql);
                st.setString(1, name);// so 1 la vi tri cua ? dau tien
                st.setString(2, email);
                st.setString(3, password);
                result =st.executeUpdate();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
               if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    //ham nay nhan vao email, password 
    //tra ve thong tin user trung email va password
     public User getUser(String email, String password){
        User result=null;
        Connection cn=null;
        try {
            //bc1: ket noi app voi sqlserver
            cn=DBUtils.getConnection();
            if(cn!=null){
                //bc 2: viet query va execute query
                String sql = "select [id],name,email,password,role,status\n"
                        + "from dbo.users\n"
                        + "where email=? and password=?  COLLATE Latin1_General_CS_AS ";
                PreparedStatement st=cn.prepareStatement(sql);
                st.setString(1, email);
                st.setString(2, password);
                ResultSet table=st.executeQuery();
                if(table!=null && table.next()){
                    //bc3: doc noi dung trong bien table
                    int id=table.getInt("id");
                    String name=table.getString("name");
                    //String email=table.getString("email");
                    //String password=table.getString("password");
                    String role=table.getString("role");
                    String status=table.getString("status");
                    result=new User(id, name, email, password, role, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
               if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
     
     //ham nay de update name,password dua vao id
    public int UpdateUser(int id, String name,String password){
         int result=0;
         // TODO: sql="update Users set name=?,password=? where id=?
         
         return result;
    }     
     
}
