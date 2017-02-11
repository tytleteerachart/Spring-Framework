<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign In</title>
    </head>
    <body>
        <div align="center">
            <h1>Sign In</h1>
            <c:url value="/login" var="loginUrl"/>
            <form action="${loginUrl}" method="POST">
                <div>
                    <label>Username:</label>
                    <input type="text" name="username" placeholder="ชื่อผู้ใช้งาน" required/>
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" placeholder="รหัสผ่าน" autocomplete="off" required/>
                </div>
                <div>
                    <input type="submit" value="Sign In"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </form>
        </div>
    </body>
</html>