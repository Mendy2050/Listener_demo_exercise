<%--
  Created by IntelliJ IDEA.
  User: 23731
  Date: 2023/5/28
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

<h1>${user.username}, welcome </h1>

<input type="button" value="add" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">

        <tr align="center">
<%--            <td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>

            <c:if test="${brand.status == 1}">
                <td>ON</td>
            </c:if>

            <c:if test="${brand.status != 1}">
                <td>OFF</td>
            </c:if>

            <td><a href="/cookie-demo/selectByIdServlet?id=${brand.id}">修改</a> <a href="#">删除</a></td>
        </tr>

    </c:forEach>

</table>


<script>
    document.getElementById("add").onclick = function (){
        location.href="addBrand.jsp"
    }
</script>


</body>
</html>