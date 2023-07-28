<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Book Information</title>
    <style>
        input[type=submit] {
            background-color: grey;
            color: white;
            padding: 2px 8px;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
            opacity: 0.9;
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
<br>
<br>
<br>
<br>
<div align="center">
<%--<h1><u>Add Book</u></h1>--%>
<form:form action="update" modelAttribute="book">
<table>
        <tr>
            <td>
                <fieldset>
                    <legend><h2 id="ldesign">Edit Book Information</h2></legend>
                    <table>
                    <tr>
                            <th>
                                <label for="id">Book Id:</label>
                            </th>
                            <td>
                                <form:input path="id" id="id" readonly="true"/>
                            </td>
                            <td>
                                 <form:errors path="id"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="bookName">Book Name:</label>
                            </th>
                            <td>
                                <form:input path="bookName" id="bookName"/>
                            </td>
                            <td>
                                 <form:errors path="bookName"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="bookType">Book Type:</label>
                            </th>
                            <td>
                                <form:select path="bookType" id="bookType">
                                    <form:option value=""/> -Select-
                                    <form:option value="Fiction"/>Fiction
                                    <form:option value="Non-Fiction"/>Non-Fiction
                                    <form:option value="Poetry"/>Poetry
                                </form:select>
                            </td>
                            <td>
                                <form:errors path="bookType"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="authorName">Author Name:</label>
                            </th>
                            <td>
                                <form:input path="authorName" id="authorName"/>
                            </td>
                            <td>
                                <form:errors path="authorName"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="vendor">Vendor:</label>
                            </th>
                            <td>
                                <form:select path="vendor">
                                    <c:forEach items="${vendors}" var="vendor">
                                        <form:option value="${vendor.id}" label="${vendor.vendor_name}" />
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:errors path="vendor"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
         <tr>
            <td align="center">
                <input type="submit" value="Update">
                <a href="${pageContext.request.contextPath}/books/list"><button class="buttonUpBack">Back</button></a>
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
