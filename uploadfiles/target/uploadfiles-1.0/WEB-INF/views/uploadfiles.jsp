<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- - - -  Meta & Title- - - -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Upload Files</title>
    </head>
    <body>
        <div align="center">
            <form action="uploadfiles" method="POST" enctype="multipart/form-data">
                <table>
                    <tr><td>File to upload:</td><td><input type="file" name="file" accept="application/pdf" required/></td></tr>
                    <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
                </table>
            </form>
        </div>
    </body>
</html>