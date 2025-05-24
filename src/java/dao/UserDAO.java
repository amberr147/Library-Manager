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
 * @author DELL
 */
public class UserDAO {
    //get user's information by email 
    //input: email
    //output: User dupplicate email

    public User getUserByEmail(String email) {
        User result = null; // dong goi mot users(object)

        Connection cn = null;  // connect database and netbeans 
        try {
            //Step 1: connect to sqlserver 
            cn = DBUtils.getConnection();
            if (cn != null) {
                //Step 2: Write query and execute query
                String sql = "select id, name, email, password, role, status\n"
                        + "from [dbo].[users]\n"
                        + "where [email] = '" + email + "'";
                Statement st = cn.createStatement();  // Only use Statement when data not complicated
                ResultSet table = st.executeQuery(sql); //executeQuery (if select)  ||   executeUpdate (if delete, update)

                //Step 3: Read content in table variable
                if (table != null && table.next()) {
                    int id = table.getInt("id");
                    String name = table.getString("name");
                    //String email = table.getString("email");  kh can thiet vi no la input
                    String password = table.getString("password");
                    String role = table.getString("role");
                    String status = table.getString("status");
                    result = new User(id, name, email, password, role, status);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result; //Step 4: return 
    }

    //This method insert a new user into user table
    public int insertNewUser(String name, String email, String password) {
        int result = 0;
        Connection cn = null;  // connect database and netbeans 
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert [dbo].[users]\n"
                        + "values (?,?,?,'user','active')"; //Symbol to place order
                PreparedStatement st = cn.prepareStatement(sql);   // Use PreparedStatement when it complicated
                st.setString(1, name);
                st.setString(2, email);
                st.setString(3, password);
                result = st.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    //get user in data to login
    public String checkUserExist(String email, String password) {
        String role = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [role] FROM [dbo].[users] "
                        + "WHERE [email] = ? AND [password] = ? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    role = rs.getString("role");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role; // null nếu không tồn tại
    }

}
