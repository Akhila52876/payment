package com.akhila.payment_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login.jsp")  // Map to /login
public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String url = "jdbc:mysql://localhost:3306/trans"; // Change to your DB
        String user = "root"; // Change if needed
        String pass = "Akhila@2003"; // Change if needed

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);

            String query = "SELECT * FROM USERS WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Dashboard.jsp");  // Redirect after login
            } else {
                response.getWriter().println("<h3>Invalid credentials! <a href='login.jsp'>Try again</a></h3>");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            response.getWriter().println("<h3>SQL Error: " + e.getMessage() + "</h3>");
        }
    }
}
