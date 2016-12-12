<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello k</h1>
    <c:forEach items="${user_list}" var="currentUser">
        <div>
        <c:out value="${currentUser.name}"/>
        <c:out value="${currentUser.age}"/>
        <c:out value="${currentUser.city}"/>
        </div>
    </c:forEach>

    <form action="users" method="post">
        <input type="text" name="name"><br>
        <input type="text" name="age"><br>
        <input type="text" name="city"><br>
        <input type="submit" value="add">
    </form>

</body>
</html>
