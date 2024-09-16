<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body bgcolor="cyan">
    <center>
        <font color="Blue"><h1>Login Form</h1></font>
        <br/><br/><br/><br/>
        <font color="red">${requestScope.errMessage}</font>
        <form action="LoginController" method="post">
            <font color="blue">Username</font>
            <input type="text" name="username"><br/>
            <font color="blue">Password</font>
            <input type="password" name="password"><br/><br/>
            <input type="submit" value="LogIn">
            <input type="reset" value="Clear"><br/><br/>
            <input type="button" value="Forget Password">
            <input type="button" value="New User" onclick="window.location.href='Register.jsp'">
        </form>
    </center>
</body>
</html>
