<%--
  Created by IntelliJ IDEA.
  User: Shoma
  Date: 19.04.2017
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>listStudents</title>
</head>
<body>
<% String message = (String) request.getAttribute("value");%>
<table border="0" width="30%">

<tr>
    <td colspan="6">  <%=message%></td>

</tr>    <%--${requestScope.value}--%>

<c:forEach items="${requestScope.list}" var="item">

    <tr>
        <td width="10%"><c:out value="${item.id}"/></td>
        <td width="30%"><c:out value="${item.name}"/></td>
        <td width="10%"><c:out value="${item.age}"/></td>
        <td width="10%"><c:out value="${item.group_id}"/></td>

        <td width="25%">

            <input type="button" value="Edit" width="100%" onclick="edit(${item.id})"/>
        </td>
        <td width="25%">
            <form action="/students/NewStudents" method="post" style="margin:0;">
                <input type="hidden" name="idDel" value="${item.id}"/>
              <input type="submit" value="Delete" width="100%"/>
            </form>
        </td>

    </tr>
<tr style="display:none;" id="edit_${item.id}">

    <td>
    <form action="/students/hello" method="post">
        <input type="hidden" name="idEdit" value="${item.id}"/>
        <input type="hidden" name="iName" value="${item.name}"/>
        <input type="hidden" name="iAge" value="${item.age}"/>
        <input type="hidden" name="iGroup" value="${item.group_id}"/>
        <input type="text" name="nameEdit" placeholder="name"/>
        <input type="text" name="ageEdit" placeholder="age"/>
        <input type="text" name="group_idEdit" placeholder="group_id"/>
        <input type="button" value="Cancel" onclick="cancel(${item.id})"/>
        <input type="submit" value="Submit"/>
    </form>
    </td>
</tr>
</c:forEach>
    <tr>
        <td colspan="2">
            <form action="/students/NewStudent.jsp" method="post">
            <input type="submit" value="Add"/>
            </form>
        </td>
    </tr>
</table>
<script>
    function cancel(id) {
        document.getElementById("edit_"+id).style.display = "none";
    }
    function edit(id) {
        document.getElementById("edit_"+id).style.display = "block";
    }
</script>
</body>
</html>
