<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- - - -  Meta & Title- - - -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Title</title>
    </head>
    <body>
        <div align="center">
            <h1>User Role Menu</h1>
            <h2>Get User Role By role_id (int)</h2>
            <form action="${pageContext.request.contextPath}/userrole" method="POST">
                <input type="text" name="role_id" required/>
                <input type="submit" value="Get User Role"/>
            </form>
            <h2 style="color: red;">${userRole}</h2>
        </div>
    </body>
</html>