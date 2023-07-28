<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ecom</title>
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

        .header p {
            float: right;
            margin-right: 60px;
            margin-top: 5px;
        }

        .button {
          background-color: orange;
          border: none;
          color: black;
          padding: 5px 20px;
          text-align: center;
          font-size: 16px;
          cursor: pointer;
          opacity: 0.7;
        }
    </style>
</head>
<body>
<div class="header">
    <img src="https://cdn.dribbble.com/users/1303634/screenshots/4736402/icon-3.jpg?compress=1&resize=400x300&vertical=top" alt="American International University" style="width:100px;height:100px;">
    <h3>Welcome to AIUB Library</h3>
    <p>
        <a href="${pageContext.request.contextPath}/users/portal"><button class="button">Home</button></a>
        <a href="${pageContext.request.contextPath}/users/list"><button class="button">Profile</button></a>
        <a href="${pageContext.request.contextPath}/users/change-password"><button class="button">Account</button></a>
        <a href="${pageContext.request.contextPath}/books/list"><button class="button">Book</button></a>
        <a href="${pageContext.request.contextPath}/vendors/list"><button class="button">Vendor</button></a>
        <a href="${pageContext.request.contextPath}/students/list"><button class="button">Student</button></a>
        <a href="${pageContext.request.contextPath}/users/sign-out"><button class="button">Logout</button></a>
    </p>
</div>
<%--<jsp:include page="../portal/footer.jsp" />--%>
</body>
</html>