package com.homepage;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import com.akhila.connection.Database_connection;

	@WebServlet("/Home_page")
	public class Home_page extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
	    	response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			
			Connection con=Database_connection.getCon();
			String query="select * from products";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				out.print("<div style='display: flex;height:100px; justify-content:end;width:90vw;'>");
				out.print("<ul style='gap:15%;display: flex;list-style:none;justify-content:space-between;'>");
				out.print("<li><a href=''>Home</a></li>");
				out.print("<li><a href=''>Cart</a></li>");
				out.print("</ul>");
				out.print("</div>");
				out.print("<div style='display: flex; flex-wrap: wrap;'>");
				while(rs.next()) {
				    out.print("<div style='border: 1px solid #ccc; padding: 16px; margin: 10px; width: 200px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);'>");
				    out.print("<img src='" + rs.getString(5) + "' style='width: 100%;'>");
				    out.print("<h3>" + rs.getString(2) + "</h3>");
				    out.print("<p>Category: " + rs.getString(3) + "</p>");
				    out.print("<p>Price: $" + rs.getString(4) + "</p>");
				    out.print("<button style='margin-right: 10px;'>Add to cart</button>");
				    out.print("<button>Buy Now</button>");
				    out.print("</div>");
				}
				out.print("</div>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

