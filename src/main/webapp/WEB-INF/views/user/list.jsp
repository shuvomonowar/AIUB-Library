<%@ page contentType="text/html;text/css;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
    <%--<link rel="stylesheet" type="text/css" href="../CSS/table-style.css">--%>
    <style>
    table, td {
      border:1px solid black;
    }

    th {
        border:1px solid black;
        background-color:dark;
        opacity:0.7;
    }

    table {
      border-collapse: collapse;
    }

    .buttonUpBack {
       background-color: grey;
       color: white;
       padding: 2px 8px;
       text-align: center;
       font-size: 16px;
       cursor: pointer;
       opacity: 0.9;
    }
    </style>
</head>
<body>
<jsp:include page="../portal/welcome.jsp" />
<%--<h1>User Profile Information, ${loggedInUser}</h1>--%>
<div align="center">
<br>
<br>
<br>
<br>
<br>
<h1>User Profile Information</h1>
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Gender</th>
        <th>Email</th>
        <th>User Created Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.fullName}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.gender}</td>
            <td>${user.email}</td>
            <td>${user.createdOn}</td>
        </tr>
        <tr>
        <c:url var="updateLink" value="/users/edit">
            <c:param name="userId" value="${user.id}" />
        </c:url>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="${updateLink}"><button class="buttonUpBack">Update</button></a>
<a href="${pageContext.request.contextPath}/users/portal"><button class="buttonUpBack">Back</button></a>
</div>
</body>
</html>
