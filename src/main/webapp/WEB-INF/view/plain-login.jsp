<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <c:if test="${param.error!=null}">
     <i class="failed">Sorry you entered invalid username/password</i>
    </c:if>
    <p>
    User Name:<input type="text" name="username">
    </p>
    <p>
    Password: <input type="text" name="password">
    </p>
    <input type="submit" value="Login">
</form:form>
</body>
</html>
