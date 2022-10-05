<%-- 
    Document   : index
    Created on : 28/09/2022, 10:11:08 AM
    Author     : S173-559
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Main Menu</h1>

        <ul>
            <li><a href="<%= request.getContextPath()%>/UserServlet">Add User</a></li>
            <li><a href="<%= request.getContextPath()%>/UserModificarServlet">Edit User</a></li>
        </ul>

    </body>
</html>