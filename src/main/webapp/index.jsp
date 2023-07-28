<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AIUB Digital Library</title>
    <style>
        .header img {
          float: left;
          width: 100px;
          height: 100px;
          background: #555;
        }

        .header h3 {
          position: relative;
          top: 42px;
          left: 1px;
          color:orange;
        }

        .header1 {
            position: relative;
            top: 0px;
            left: 35px;
            color:black;
        }
    </style>
</head>
<body>
<div class="header">
    <img src="https://cdn.dribbble.com/users/1303634/screenshots/4736402/icon-3.jpg?compress=1&resize=400x300&vertical=top" alt="American International University" style="width:100px;height:100px;">
    <h3>AIUB Library</h3>
</div>
<br><br><br><br><br><br>
<div class="header1">
    <a href="${pageContext.request.contextPath}/users/sign-up">SignUp</a>
    |
    <a href="${pageContext.request.contextPath}/users/sign-in">SignIn</a>
</div>
</body>
</html>