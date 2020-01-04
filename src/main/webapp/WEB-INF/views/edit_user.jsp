<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit User</title>
</head>
<body>
<center>
    <h2>Edit User</h2>
    <form:form action="/admin/users/update?id=${user.id}" method="post" modelAttribute="user">
        Email:<br>
        <form:input type="email" path="email" value="${user.email}"/>
        <br>
        Password:<br>
        <form:input type="text" path="password" value="${user.password}"/>
        <br>
        <form:radiobutton path="role" value="ROLE_USER"/> User<br>
        <form:radiobutton path="role" value="ROLE_ADMIN"/> Admin<br>
        <br>
        <c:if test="${validValues != null}">
            ${validValues}
        </c:if>
        <br>
        <input type="submit" value="Edit user">
    </form:form>
</center>
</body>
</html>
