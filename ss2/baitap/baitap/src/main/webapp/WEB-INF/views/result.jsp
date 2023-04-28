<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/28/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <form action="/home/caculator">
    <div class="input-group">
      <input type="number"
             class="form-control" name="number1"  aria-describedby="helpId" placeholder="Nhập số đầu tiên">
      <input type="number"
             class="form-control" name="number2"  aria-describedby="helpId" placeholder="Nhập số thứ hai">
    </div>
    <div>
      <button type="submit" class="btn btn-secondary" name="caculator" value="Addition">Addition(+)</button>
      <button type="submit" class="btn btn-secondary" name="caculator" value="Subtraction">Subtraction(-)</button>
      <button type="submit" class="btn btn-secondary" name="caculator" value="Multiplication">Multiplication(x)</button>
      <button type="submit" class="btn btn-secondary" name="caculator" value="Division">Division(/)</button>
    </div>
  </form>

</div>

<div>
  Result : ${result}
</div>
</body>
</html>