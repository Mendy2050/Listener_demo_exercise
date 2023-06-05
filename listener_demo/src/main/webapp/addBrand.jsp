<%--
  Created by IntelliJ IDEA.
  User: 23731
  Date: 2023/5/28
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Add Brand</title>
</head>
<body>
<h3>Add Brand</h3>
<form action="/cookie-demo/addServlet" method="post">
    Brand Name: <input name="brandName"><br>
    Company Name: <input name="companyName"><br>
    Order: <input name="ordered"><br>
    Description: <textarea rows="5" cols="20" name="description"></textarea><br>
    Status:
    <input type="radio" name="status" value="0">ON
    <input type="radio" name="status" value="1">OFF<br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
