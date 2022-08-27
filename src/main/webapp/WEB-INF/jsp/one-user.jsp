<jsp:useBean id="user" scope="request" type="by.grovs._4_entity.User"/>
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

<h1>User </h1>
<table>

    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Password</th>

    </tr>

    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.password}</td>

        <td>

        </td>
    </tr>


</table>
</body>
</html>
