<%-- 
    Document   : index
    Created on : Jan 20, 2018, 8:39:08 PM
    Author     : SHUBHAM
--%>

<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Statement st=DBConnector.getStatement();
        %>
        <h1>Hello World!</h1>
    </body>
</html>
