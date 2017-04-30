<%--
  Created by IntelliJ IDEA.
  User: Shoma
  Date: 20.04.2017
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового студента</title>
</head>
<body>
<form action="/NewStudents" method="post">
    <input type="text" name="nameAdd" placeholder="name"/>
    <input type="text" name="ageAdd" placeholder="age"/>
    <input type="text" name="group_idAdd" placeholder="group_id"/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
