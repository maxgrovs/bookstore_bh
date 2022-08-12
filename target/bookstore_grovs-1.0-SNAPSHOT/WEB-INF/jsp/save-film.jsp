<%--
  Created by IntelliJ IDEA.
  User: maxgrovs
  Date: 13.02.2021
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/save-film" method="post">

    <label>Name:
        <input type="text" name="name" />
    </label>
    <br><br>

    <input type="submit" value="SAVE" />

</form>
</body>
</html>
