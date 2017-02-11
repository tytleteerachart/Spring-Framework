<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>GRADUATE STUDENT</title>
    </head>
    <body>
        <h1>GRADUATE STUDENT</h1>
        <c:url value="/logout" var="logoutUrl"/>
        <form action="${logoutUrl}" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Sign Out"/>
        </form>
    </body>
</html>