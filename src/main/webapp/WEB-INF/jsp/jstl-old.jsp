<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <%-----------------------------------------ссылки--------------------------------------------------%>

    <%--<c:if test="${requestScope.request.description eq 'TEST'}">
           <span>Description OK!</span>
       </c:if>--%>
    <%-----------------------------------------ссылки--------------------------------------------------%>

    <%--<c:forEach var="request" items="${sessionScope.requests}">
            <span>${request.date}. ${request.description}</span>
            <a href="${pageContext.request.contextPath}/request?id=${request.id}">Link to display request</a>
        </c:forEach>--%>
    <%-----------------------------------------ссылки--------------------------------------------------%>
    <%-----------------------------------------выпадающий список--------------------------------------------------%>
    <%-- <form action="${pageContext.request.contextPath}/jstl" method="get">
         <select name="language">
             <option value="J">Java</option>
             <option value="R">Ruby</option>
             <option value="PHP">PHP</option>
             <option >Ooops!</option>
         </select>--%>
    <%-----------------------------------------выпадающий список--------------------------------------------------%>

    <form action="${pageContext.request.contextPath}/jstl" method="get">
        <input type="checkbox" name="language" value="J">Tаня <br>
        <input type="checkbox" name="language" value="R">Макс <br>
        <input type="checkbox" name="language" value="P">PHP <br>

        <input type="submit" value="SEND">
        <%-----------------------------------------checkbox--------------------------------------------------%>

    </form>


</div>
</body>
</html>

