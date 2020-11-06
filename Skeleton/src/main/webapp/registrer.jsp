<%--
  Created by IntelliJ IDEA.
  User: Girov
  Date: 05.11.2020
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>Halldor sin mannehule</h1>
    <form action="ResultatServlet" method="POST">
        <table style="with: 80%">
            <tr>
                <td>Fornavn</td>
                <td><input type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td>Etternavn</td>
                <td><input type="text" name="lastName" /></td>
            </tr>
            <tr>
                <td>Test1</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Test2</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td> test3? </td>
                <td><input type="text" name="address" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
