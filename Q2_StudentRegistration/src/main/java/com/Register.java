package com;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;


    String url = "jdbc:mysql://localhost:3306/IGT_test";
    String username = "root";
    String password = "123456789";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String phone = request.getParameter("phone");
        String marks = request.getParameter("marks");
        String branch = request.getParameter("branch");

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO students (sid, sname, phone, marks, branch) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, sid);
            preparedStatement.setString(2, sname);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, marks);
            preparedStatement.setString(5, branch);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

            
            response.sendRedirect("success.html");
           
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
          
            response.sendRedirect("error.html");
        }
    }
}
