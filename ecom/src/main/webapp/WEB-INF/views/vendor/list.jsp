<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vendors List and Information</title>
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
<br>
<br>
<br>
<br>
<div align="center">
<h1>Vendors List & Information</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Vendor Name</th>
        <th>Vendor Address</th>
        <th>Vendor Created Date</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${vendors}" var="vendor">
        <tr>
            <c:url var="updateLink" value="/vendors/edit">
                <c:param name="vendorId" value="${vendor.id}" />
            </c:url>
            <c:url var="deleteLink" value="/vendors/delete">
                <c:param name="vendorId" value="${vendor.id}" />
            </c:url>
            <td>${vendor.id}</td>
            <td>${vendor.vendor_name}</td>
            <td>${vendor.vendor_address}</td>
            <td>${vendor.createdOn}</td>
            <td><a href="${updateLink}"><button class="buttonUpDel">Update</button></a> | <a href="${deleteLink}"><button class="buttonUpDel">Delete</button></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><input type="button" value="Add New Vendor" onclick="window.location.href='create';return false;"></td>
    </tr>
    </tbody>
</table>
</div>
</body>
</html>
