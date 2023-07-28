<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Vendor Information</title>
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
<%--<h1>Edit Vendor Information</h1>--%>
<form:form action="update" modelAttribute="vendor">
<table>
    <tr>
        <td>
            <fieldset>
                <legend><h2 id="ldesign">Edit Vendor Information</h2></legend>
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
                            <label for="vendor_name">Vendor Name:</label>
                        </th>
                        <td>
                            <form:input path="vendor_name" id="vendor_name"/>
                        </td>
                        <td>
                             <form:errors path="vendor_name"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="vendor_address">Vendor Address:</label>
                        </th>
                        <td>
                            <form:input path="vendor_address" id="vendor_address"/>
                        </td>
                        <td>
                            <form:errors path="vendor_address"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
     <tr>
        <td align="center">
            <input type="submit" value="Update">
            <a href="${pageContext.request.contextPath}/vendors/list"><button class="buttonUpBack">Back</button></a>
        </td>
    </tr>
</table>
</form:form>
</div>
</body>
</html>
