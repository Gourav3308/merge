<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <center><h2>Welcome Page</h2></center>
    <b>Welcome, ${sessionScope.username}</b>
    <br><br>
    <form action="LogoutController" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
