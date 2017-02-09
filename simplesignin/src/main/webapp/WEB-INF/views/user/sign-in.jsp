<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- - - -  Meta & Title- - - -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign In</title>
    </head>
    <body>
        <!-- [START CONTAINER] -->
        <div align="center" style="margin-top: 30px;">
            <c:url value="/login" var="loginUrl"/>
            <form action="${loginUrl}" method="post">
                <div style="margin-bottom: 10px;">
                    <label>Username</label>
                    <input placeholder="Username" name="username" type="text" required/>
                </div>
                <div style="margin-bottom: 10px;">
                    <label>Password</label>
                    <input placeholder="Password" name="password" type="password" required autocomplete="off"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Sign In</button>
            </form>
        </div>
        <!-- [END CONTAINER] -->
    </body>
</html>