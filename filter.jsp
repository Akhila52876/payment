<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Filter Transactions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(45deg, #8b5aed, #78ebfc);
            color: white;
            text-align: center;
        }
        form {
            background: white;
            color: black;
            padding: 20px;
            display: inline-block;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        select, input {
            margin: 10px;
            padding: 5px;
        }
    </style>
</head>
<body>

<h2>Select Filters</h2>

<!-- Filter Form -->
<form method="get" action="pagination.jsp">
    <label>Source Type:</label>
    <select name="source_type">
        <option value="">All</option>
        <option value="Bank">Bank</option>
        <option value="Wallet">Wallet</option>
        <option value="Card">Card</option>
    </select>
    
    <br>
    
    <label>Destination Type:</label>
    <select name="dest_type">
        <option value="">All</option>
        <option value="Bank">Bank</option>
        <option value="Wallet">Wallet</option>
        <option value="Card">Card</option>
    </select>

    <br>
    
    <label>Records per page:</label>
    <select name="records_per_page">
        <option value="5">5</option>
        <option value="10" selected>10</option>
        <option value="20">20</option>
    </select>
    
    <br><br>
    <input type="submit" value="Apply Filter">
</form>

</body>
</html>
