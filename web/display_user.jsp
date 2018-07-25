<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: babin
  Date: 5/4/18
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="Navbar/MPage.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-2">
<table class="table table-bordered" style="width: 50%">
    <thead>
    <tr>
        <%--<th scope="col">id</th>--%>
        <th scope="col">Username</th>
        <th scope="col">Address</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Category</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%--<th scope="row">${user.id}</th>--%>
        <td>${user.username}</td>
        <td> ${user.address}</td>
        <td> ${user.email}</td>
        <td>${user.phone}</td>
        <td>${user.category}</td>
    </tr>
    </tbody>
</table>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-2">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <%--<th scope="col">Id</th>--%>
                    <th scope="col">Ideas</th>
                    <c:choose>
                        <c:when test="${user.username != currentUser.username}" >

                        </c:when>
                        <c:otherwise>
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
                        </c:otherwise>
                    </c:choose>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userIdeas}" var="idea">
                    <tr>
                        <%--<td> <c:out value="${idea.id}"/> </td>--%>
                            <%--<td><a href="viewIdea?page=viewIdea&id=${idea.user}">Edit</a> </td>  --%>
                        <td>

                            <c:out  value="${idea.idea}"/>

                        </td>
                        <c:choose>
                            <c:when test="${user.username != currentUser.username}" >

                            </c:when>
                            <c:otherwise>
                                <td><a href="editIdea?page=editIdea&id=${idea.id}">Edit</a> </td>
                                <td><a href="deleteIdea?page=deleteIdea&id=${idea.id}">Delete</a> </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>





                </tbody>
            </table>

        </div>
    </div>

</div>

</body>
</html>
