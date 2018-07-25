<%--
  Created by IntelliJ IDEA.
  User: babin
  Date: 5/2/18
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%><html>
<head>
    <title>Please Register</title>
    <link rel="stylesheet" href="css/signup.css">
</head>
<body>
<%--<%@include file="Navbar/MPage.jsp" %>--%>
<div class="signup">
    <div class="signup-header"><h2 >Sign Up</h2></div>

    <form class="signup-container" action="signup" method="post" required>
        <input type="hidden" name="page" value="signup">

        <p><input type="text" placeholder="Your Name" name="name" required> </p>
        <p><input type="tel" placeholder="Phone Number" name="phone" required> </p>
        <p><input type="text" placeholder="Address" name="address" required> </p>
        <p><input type="email" placeholder="Email" name="email" required></p>
        <p><input type="password" placeholder="Password" name="password" required></p>
        <p>

            Choose Category:<br>
            <select name="category">
                <option value="investor">Investor</option>
                <option value="ideapitcher">Idea Pitcher</option>
            </select>
        </p>
        <p><input type="submit" value="Register"></p>
    </form>
</div>
</body>
</html>
