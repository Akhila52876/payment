package com.akhila.payment_project;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests (Optional - Can be used to show a registration form)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("register.jsp"); // Redirect to registration page
    }

    // Handle POST requests (For form submission)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        if (fullname != null && email != null && username != null && password != null 
                && confirmPassword != null && password.equals(confirmPassword)) {
            
            String url = "jdbc:mysql://localhost:3306/trans"; 
            String user = "root"; 
            String pass = "Akhila@2003";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, pass);

                String query = "INSERT INTO USERS (fullname, email, username, password) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, fullname);
                stmt.setString(2, email);
                stmt.setString(3, username);
                stmt.setString(4, password);

                int rows = stmt.executeUpdate();
                stmt.close();
                conn.close();

                if (rows > 0) {
                    response.sendRedirect("login.jsp"); // Redirect to login page after success
                } else {
                    response.getWriter().println("<h3>Registration failed.</h3>");
                }

            } catch (Exception e) {
                response.getWriter().println("<h3>SQL Error: " + e.getMessage() + "</h3>");
            }
        } else {
            response.getWriter().println("<h3>Passwords do not match! <a href='register.jsp'>Try again</a></h3>");
        }
    }
}
