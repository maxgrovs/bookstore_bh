<%@ page import="by.grovs._4_entity.User" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: rujuanxing
  Date: 10/12/20
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%

%>


<head>
    <title>User List</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<c:forEach var="i" begin="1" end="8">
    <%--    ${i}--%>
</c:forEach>


<h1>User List</h1>
<table>

    <tr>

        <th>First name</th>
        <th>Last name</th>

    </tr>


    <c:forEach var="user" items="${users}" varStatus="status" step="1">
        <tr>

            <td>
                <a href="${pageContext.request.contextPath}book-store?command=user&id=${user.id}"> ${user.firstName}</a>
            </td>
            <td>${user.lastName}</td>


            <td>

            </td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
