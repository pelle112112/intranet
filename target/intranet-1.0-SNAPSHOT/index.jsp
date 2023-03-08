<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Hej Intranet</h1>

<c:if test="${empty(sessionScope.user)}">
    <p>Du kan logge på her: <a href="login.jsp">Login</a> </p>
</c:if>

<c:if test="${sessionScope.user != null}">

    <p>Status på login: ${sessionScope.user.login} er logget på.</p>
    <p>${sessionScope.user.login} ${sessionScope.user.password} ${sessionScope.user.role}</p>
</c:if>


<a href="classlist.jsp">Se Klasseliste</a>

<a href="contact.jsp">Kontaktside</a>
</body>
</html>