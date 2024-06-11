<%-- 
    Document   : login
    Created on : 11 Jun 2024, 11:29:31 PM
    Author     : ltham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="j_username" required=""></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="j_password" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
