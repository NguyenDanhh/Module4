<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/27/2023
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>dictionary</h1>
<form action="/dictionary">
  <label> vacabulary : </label>
  <input type="text" name="dictionary">
  <div>
      translate : ${result}
  </div>
    <div>
        <input type="submit" value="FIND">
    </div>
</form>
</body>
</html>
