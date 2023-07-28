<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create New Vendor</title>
    <style>
        input[type=submit] {
            background-color: grey;
            color: white;
            padding: 2px 8px;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
            opacity: 0.9;
            margin-top: 5px;
        }

        .buttonUpBack {
           background-color: grey;
           color: white;
           padding: 2px 8px;
           text-align: center;
           font-size: 16px;
           cursor: pointer;
           opacity: 0.9;
           margin-left: 0px;
           margin-bottom: 150px;
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
<%--<h1>Create New Vendor</h1>--%>
<form:form action="store" modelAttribute="vendor">
<table>
    <tr>
        <td>
            <fieldset>
                <legend><h2 id="ldesign">Create New Vendor</h2></legend>
                <table>
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
            <input type="submit" value="Add Vendor">
        </td>
    </tr>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/vendors/list"><button class="buttonUpBack">Back</button></a>
</div>
</body>
</html>
