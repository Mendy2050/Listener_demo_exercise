<%--
  Created by IntelliJ IDEA.
  User: 23731
  Date: 2023/5/30
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Update Brand</title>
</head>
<body>
<h3>Update Brand</h3>
<form action="/listener_demo/updateServlet" method="post">

    <%--hidden field--%>
    <input type="hidden" name="id"  value="${brand.id}">

    Brand Name: <input name="brandName" value="${brand.brandName}">  <br>
    Company Name: <input name="companyName" value="${brand.companyName}">  <br>
    Order: <input name="ordered" value="${brand.ordered}"> <br>
    Description: <textarea rows="5" cols="20" name="description"> ${brand.description}  </textarea>  <br>
    Status:
    <c:if test="${brand.status == 0}">
        <input type="radio" name="status" value="0" checked >OFF<br>
        <input type="radio" name="status" value="0">ON<br>
    </c:if>

    <c:if test="${brand.status == 1}">
        <input type="radio" name="status" value="0" >OFF<br>
        <input type="radio" name="status" value="0" checked >ON<br>
    </c:if>

    <input type="submit" value="Submit">
</form>
</body>
</html>
