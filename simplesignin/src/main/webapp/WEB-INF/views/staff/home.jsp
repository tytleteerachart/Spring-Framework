<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- - - -  Meta & Title- - - -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
    </head>
    <body>
        <!-- [START CONTAINER] -->
        <div align="center">
            <h1>Welcome to Staff Home</h1>
            <c:url value="/logout" var="logoutUrl"/>
            <form action="${logoutUrl}" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button type="submit">Sign Out</button>
            </form>
        </div>
        <!-- [END CONTAINER] -->
    </body>
</html>