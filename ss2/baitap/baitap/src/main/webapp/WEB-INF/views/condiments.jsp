<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/28/2023
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<div class="container">
    <form>
        <h1>Sandwich Condiments</h1>
        <div class="form-check">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Lettuce" >
                Lettuce
            </label>
        </div>
        <div>
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Tomato" >
                Tomato
            </label>
        </div>
        <div>
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Mustard" >
                Mustard
            </label></div>
        <div>
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Sprouts" >
                Sprouts
            </label>
        </div>
        <button type="submit" class="btn btn-secondary">Submit</button>
    </form>
</div>

<div>
    <ul>
        <c:forEach var="element" items="${list}">
            <li>
                    ${element}
            </li>
        </c:forEach>
    </ul>

</div>
</body>
</html>