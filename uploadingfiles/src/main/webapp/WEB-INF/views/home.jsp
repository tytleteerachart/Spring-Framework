<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home</title>

        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div align="center">
            <h2>Upload only .pdf file</h2>
            <form action="${pageContext.request.contextPath}/home" method="POST" enctype="multipart/form-data">
                <input type="file" name="file" required accept="application/pdf"/>
                <input type="submit" value="Upload"/>
            </form>
            <h3 style="color: red;">${message}</h3>
        </div>
        <div style="margin-top: 50px;">
            <table width="100%">
                <tr>
                    <th>File Name</th>
                    <th>(.pdf)</th>
                </tr>
                <c:forEach items="${filenames}" var="name">
                    <tr>
                        <td>${name}</td>
                        <td><a href="http://localhost:8084/uploadingfiles/file/${name}">open</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>