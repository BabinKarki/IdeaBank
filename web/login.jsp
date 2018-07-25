<%--
  Created by IntelliJ IDEA.
  User: babin
  Date: 5/2/18
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head><title>Log In</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/login.css">
</head>
<form method="post" action="login">
    <input type="hidden" name="page" value="login">
<div class="container">
  <div class="login-form col-md-4 offset-md-4">
   <h1 class="title">Log In</h1>
    <div class="form-group">
  <label>Email</label>
  <%--<input type="text" name="name" class="form-control" required>--%>
  <input type="text" name="email" class="form-control" required>
</div>

<div class="form-group">
  <label>Password</label>
  <input type="password" name="password" class="form-control" hidden required>
</div>
    <input type="submit" button class="btn btn-primary btn-block" value="Submit"/>
      <p> <a href="signup.jsp" style="alignment: center">New?Register Here</a></p><br>
      ${msg} ${msg1}
  </div>
</div>
  </form>
</body>
</body>
</html>