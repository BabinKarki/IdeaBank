<%--
  Created by IntelliJ IDEA.
  User: babin
  Date: 5/4/18
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ideas</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<%@include file="Navbar/MPage.jsp" %>

<form action="update" method="post">
    <input type="hidden" name="page" value="update">
    <input type="hidden" name="id" value="${idea.id}">

    <div class="text" style="display:inline-block;">
        <p style="alignment: center">Post Your Ideas</p>
        <nav class="navbar navbar-default navbar-fixed-side">
            <textarea class="form-control" id="ideaText" aria-label="With textarea" name="idea" required style="height: 20em;resize: none;">
                ${idea.idea}
            </textarea>
            <input type="submit"  button class="btn btn-primary btn-block" value="Update"></inputbutton>
        </nav>
    </div>
</form>



<%--<div class="container" style="display: block;  height: 450px; overflow-y: scroll;">--%>
    <%--<table class="table table-hover">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th scope="col">Id</th>--%>
            <%--<th scope="col">Idea By</th>--%>
            <%--<th scope="col">Idea</th>--%>
            <%--<th scope="col"> View </th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--${idea.user}--%>
        <%--<c:forEach items="${ideaList}" var="idea">--%>
            <%--<tr>--%>
                <%--<td> <c:out value="${idea.id}"/> </td>--%>
                    <%--&lt;%&ndash;<td><a href="viewIdea?page=viewIdea&id=${idea.user}">Edit</a> </td>  &ndash;%&gt;--%>
                <%--<td> <c:out value="${idea.user.username}"/> </td>--%>
                <%--<td>--%>

                    <%--<c:out  value="${idea.idea}"/>--%>

                <%--</td>--%>
                <%--<td>--%>
                    <%--<a href="userDetails?page=details&id=${idea.user.id}">--%>
                        <%--View--%>
                    <%--</a>--%>
                <%--</td>--%>

            <%--</tr>--%>
        <%--</c:forEach>--%>


        <%--</tbody>--%>

    <%--</table>--%>
<%--</div>--%>


</body>
</html>
