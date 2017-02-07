<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Sign In</title>
    </head>
    <body>
        <div align="center">
            <h2>Sign In Form</h2>
            <form action="${pageContext.request.contextPath}/user/sign-in" method="POST">
                <label>Username:</label>
                <input type="text" name="username" autofocus required/>
                <label>Password:</label>
                <input type="password" name="password" autocomplete="off" required/>
                <input type="submit" value="Sign In"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </body>
</html>