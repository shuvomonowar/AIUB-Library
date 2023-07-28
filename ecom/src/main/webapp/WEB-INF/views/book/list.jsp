<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books List and Information</title>
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

        .buttonUpDel {
           background-color: grey;
           color: white;
           padding: 5px 5px;
           text-align: center;
           font-size: 12px;
           cursor: pointer;
           opacity: 0.9;
           font-weight: bold;
        }

        input[type=button] {
            background-color: grey;
            color: white;
            padding: 5px 5px;
            text-align: center;
            font-size: 12px;
            cursor: pointer;
            opacity: 0.9;
            font-weight: bold;
        }

        input[type=submit] {
            background-color: grey;
            color: white;
            padding: 5px 5px;
            text-align: center;
            font-size: 12px;
            cursor: pointer;
            opacity: 0.9;
            font-weight: bold;
        }

        .searchBtn {
            margin-right: 630px;
        }
    </style>
</head>
<body>
<jsp:include page="../portal/welcome.jsp" />
<br>
<br>
<br>
<br>
<div align="center">
<h1>Book List & Information</h1>
<div class="searchBtn">
<form:form action="search" modelAttribute="book">
    <input type="text" path="book_name" name="bookName" placeholder="Search.." />
    <%--<c:param name="bookName" value="${request.getParameter("bookName")}" />--%>
    <input type="submit" value="Search">
</form:form>
</div>
<br>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Book Name</th>
        <th>Book Type</th>
        <th>Author Name</th>
        <th>Issue Date</th>
        <th>Vendor Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <c:url var="updateLink" value="/books/edit">
                <c:param name="bookId" value="${book.id}" />
            </c:url>
            <c:url var="deleteLink" value="/books/delete">
                <c:param name="bookId" value="${book.id}" />
            </c:url>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.bookType}</td>
            <td>${book.authorName}</td>
            <td>${book.issueDate}</td>
            <td>${book.vendor.vendor_name}</td>
            <td><a href="${updateLink}"><button class="buttonUpDel">Update</button></a> | <a href="${deleteLink}"><button class="buttonUpDel">Delete</button></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><input type="button" value="Add New Book" onclick="window.location.href='create';return false;"></td>
    </tr>
    </tbody>
</table>
</div>
</body>
</html>
