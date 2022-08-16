<%@ page import="by.grovs._4_entity.Book" %>
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
    <title>Book List</title>
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

<h1>Book </h1>
<table>
    <%

    %>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Date of publication</th>
    </tr>

    <tr>
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.date}</td>

        <td>
<%--            <c:if test="${person.address == null}">--%>
<%--                No Address--%>
<%--            </c:if>--%>

<%--            <c:if test="${person.address != null}">--%>
<%--                ${person.address.street} ${person.address.city} ${person.address.state}--%>
<%--            </c:if>--%>

<%--            <c:choose>--%>
<%--                <c:when test="${person.address == null}">--%>
<%--                    No Address--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    ${person.address.street} ${person.address.city} ${person.address.state}--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
        </td>
    </tr>


</table>
</body>
</html>
