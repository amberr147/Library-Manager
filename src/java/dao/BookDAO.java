/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class BookDAO {

    public ArrayList<Book> getBooks(String name, String au, String cate) {
        ArrayList<Book> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select id,title,author,isbn,category,published_year,total_copies,available_copies,status,url\n"
                        + "from dbo.books\n"
                        + "where title like ? or author like ? or category like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + name + "%");
                st.setString(2, "%" + au + "%");
                st.setString(3, "%" + cate + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int id = table.getInt("id");
                        String title = table.getString("title");
                        String author = table.getString("author");
                        String isbn = table.getString("isbn");
                        String category = table.getString("category");
                        int year = table.getInt("published_year");
                        int totol_copy = table.getInt("total_copies");
                        int available_copy = table.getInt("available_copies");
                        String status = table.getString("status");
                        String url = table.getString("url");
                        Book b = new Book(id, title, author, isbn, category, year, totol_copy, available_copy, status, url);
                        list.add(b);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public Book getBook(int id) {
        Book b = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select id,title,author,isbn,category,published_year,total_copies,available_copies,status,url\n"
                        + "from dbo.books\n"
                        + "where title like ? or author like ? or category like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, id);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String title = table.getString("title");
                        String author = table.getString("author");
                        String isbn = table.getString("isbn");
                        String category = table.getString("category");
                        int year = table.getInt("published_year");
                        int totol_copy = table.getInt("total_copies");
                        int available_copy = table.getInt("available_copies");
                        String status = table.getString("status");
                        String url = table.getString("url");
                        b = new Book(id, title, author, isbn, category, year, totol_copy, available_copy, status, url);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return b;
    }

}
