<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/27/2023
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Currency converter app </h1>
<form action="/currency">
    <label>USD</label>
    <input name="usd" type="number">
    <div>
        <h3>VND : ${result} USD</h3>
    </div>
    <div>
        <input type="submit" value="Total">
    </div>
</form>
</body>
</html>
