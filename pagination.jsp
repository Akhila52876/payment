<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Transaction List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(45deg, #8b5aed, #78ebfc);
            color: white;
            text-align: center;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            color: black;
        }
        th, td {
            padding: 10px;
            border: 1px solid black;
        }
        .pagination a {
            margin: 5px;
            padding: 5px 10px;
            text-decoration: none;
            background: blue;
            color: white;
            border-radius: 5px;
        }
        .pagination a.active {
            background: darkblue;
        }
    </style>
</head>
<body>

<h2>Transaction List</h2>

<%! 
class Transaction {                     
    private int trans_id;
    private String trans_datetime;
    private int source_id;
    private int dest_id;
    private String source_type;
    private String dest_type;
    private int trans_amount;

    public Transaction(int trans_id, String trans_datetime, int source_id, int dest_id, String source_type, String dest_type, int trans_amount) {
        this.trans_id = trans_id;
        this.trans_datetime = trans_datetime;
        this.source_id = source_id;
        this.dest_id = dest_id;
        this.source_type = source_type;
        this.dest_type = dest_type;
        this.trans_amount = trans_amount;
    }

    public int getTransId() { return trans_id; }
    public String getTransDatetime() { return trans_datetime; }
    public int getSourceId() { return source_id; }
    public int getDestId() { return dest_id; }
    public String getSourceType() { return source_type; }
    public String getDestType() { return dest_type; }
    public int getTransAmount() { return trans_amount; }
}
%>

<%
    int page1 = 1;
    int recordsPerPage = 10;
    String selectedSourceType = request.getParameter("source_type");
    String selectedDestType = request.getParameter("dest_type");

    if (request.getParameter("page1") != null) {
        page1 = Integer.parseInt(request.getParameter("page1"));
    }

    if (request.getParameter("records_per_page") != null) {
        recordsPerPage = Integer.parseInt(request.getParameter("records_per_page"));
    }

    List<Transaction> transactions = new ArrayList<>();
    int totalRecords = 0;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans", "root", "Akhila@2003");

        // Secure query with PreparedStatement
        String query = "SELECT * FROM transaction WHERE 1=1";
        List<String> params = new ArrayList<>();
        
        if (selectedSourceType != null && !selectedSourceType.isEmpty()) {
            query += " AND source_type = ?";
            params.add(selectedSourceType);
        }
        if (selectedDestType != null && !selectedDestType.isEmpty()) {
            query += " AND dest_type = ?";
            params.add(selectedDestType);
        }
        query += " LIMIT ?, ?";

        PreparedStatement ps = con.prepareStatement(query);

        int paramIndex = 1;
        for (String param : params) {
            ps.setString(paramIndex++, param);
        }
        ps.setInt(paramIndex++, (page1 - 1) * recordsPerPage);
        ps.setInt(paramIndex, recordsPerPage);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            transactions.add(new Transaction(
                rs.getInt("trans_id"), rs.getString("trans_datetime"),
                rs.getInt("source_id"), rs.getInt("dest_id"),
                rs.getString("source_type"), rs.getString("dest_type"),
                rs.getInt("trans_amount")));
        }

        // Count total records with filters
        String countQuery = "SELECT COUNT(*) FROM transaction WHERE 1=1";
        if (selectedSourceType != null && !selectedSourceType.isEmpty()) {
            countQuery += " AND source_type = ?";
        }
        if (selectedDestType != null && !selectedDestType.isEmpty()) {
            countQuery += " AND dest_type = ?";
        }

        PreparedStatement countPs = con.prepareStatement(countQuery);
        int countParamIndex = 1;
        for (String param : params) {
            countPs.setString(countParamIndex++, param);
        }

        ResultSet Rs = countPs.executeQuery();
        if (Rs.next()) {
            totalRecords = Rs.getInt(1);
        }

        con.close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        out.println("<h3>Error retrieving data</h3>");
    }

    int lastPage = (int) Math.ceil((double) totalRecords / recordsPerPage);
%>

<table>
<tr>
    <th>ID</th>
    <th>DateTime</th>
    <th>Source ID</th>
    <th>Dest ID</th>
    <th>Source Type</th>
    <th>Dest Type</th>
    <th>Amount</th>
</tr>
<% for (Transaction t : transactions) { %>
<tr>
    <td><%=t.getTransId() %></td>
    <td><%=t.getTransDatetime() %></td>
    <td><%=t.getSourceId() %></td>
    <td><%=t.getDestId() %></td>
    <td><%=t.getSourceType() %></td>
    <td><%=t.getDestType() %></td>
    <td><%=t.getTransAmount() %></td> 
</tr>
<% } %>
</table>

<!-- Pagination Links -->
<div class="pagination">
    <% if (page1 > 1) { %>
        <a href="pagination.jsp?page1=<%= page1 - 1 %>&source_type=<%= selectedSourceType %>&dest_type=<%= selectedDestType %>&records_per_page=<%= recordsPerPage %>">Previous</a>
    <% } %>

    <% for (int i = 1; i <= lastPage; i++) { %>
        <a href="pagination.jsp?page1=<%= i %>&source_type=<%= selectedSourceType %>&dest_type=<%= selectedDestType %>&records_per_page=<%= recordsPerPage %>" 
           class="<%= (i == page1) ? "active" : "" %>"><%= i %></a>
    <% } %>

    <% if (page1 < lastPage) { %>
        <a href="pagination.jsp?page1=<%= page1 + 1 %>&source_type=<%= selectedSourceType %>&dest_type=<%= selectedDestType %>&records_per_page=<%= recordsPerPage %>">Next</a>
    <% } %>
</div>

<br>
<a href="filter.jsp">Change Filters</a>

</body>
</html>
