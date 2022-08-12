<%--
  Created by IntelliJ IDEA.
  User: maxgrovs
  Date: 14.02.2021
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <c:if test="${requestScope.film.name eq 'TEST'}"> <%-- аналогия if(){} --%>
        <span>Name OK!</span>
    </c:if>

    <c:forEach var="film" items="${requestScope.films}">

        <div>
            <span>${film.id}. ${film.name}</span>
            <a href="${pageContext.request.contextPath}/filmDto?id=${film.id}">Link to display film</a>
        </div>

    </c:forEach>

</div>

</body>
</html>
