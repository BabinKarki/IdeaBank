<%@ page import="domain.Idea" %>
<%@ page import="java.util.PrimitiveIterator" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: babin
  Date: 5/2/18`
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page import="domain.Idea" %>--%>
<%--<%@page import="java.util.List" %>--%>
<html>
<head>
    <title>Ideas</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<%@include file="Navbar/MPage.jsp" %>

 <div style="font-size: 25px"> Welcome <%=(String)session.getAttribute("username")%></div>
    <form action="/idea" method="post">
        <input type="hidden" name="page" value="post_idea">
        <input type="hidden" name="id" value="<%=session.getAttribute("id")%>">

        <div class="text" style="display:inline-block;">
            <p style="alignment: center">Post Your Ideas</p>
            <nav class="navbar navbar-default navbar-fixed-side">
                <textarea class="form-control" aria-label="With textarea" name="idea" required style="height: 20em;resize: none;"></textarea>
                <input type="submit"  button class="btn btn-primary btn-block" value="Submit"></inputbutton>

            </nav>
        </div>
    </form>



<div class="container" style="display: block;  height: 450px; overflow-y: scroll;">
<table class="table table-hover">
    <thead>
    <tr>
        <%--<th scope="col">Id</th>--%>
        <th scope="col">Idea By</th>
        <th scope="col">Category</th>
        <th scope="col">Idea</th>
        <th scope="col"> View </th>
    </tr>
    </thead>
    <tbody>
    ${idea.user}
    <c:forEach items="${ideaList}" var="idea">
        <tr>
            <%--<td> <c:out value="${idea.id}"/> </td>--%>

            <%--<td><a href="viewIdea?page=viewIdea&id=${idea.user}">Edit</a> </td>  --%>
            <td> <c:out value="${idea.user.username}"/> </td>
            <td> <c:out value="${idea.user.category}"/> </td>
            <td>

                    <c:out  value="${idea.idea}"/>

            </td>


            <td>
                <a href="userDetails?page=details&id=${idea.user.id}">
                View
                </a>
            </td>

        </tr>
    </c:forEach>


    </tbody>

</table>
</div>



</body>
</html>
