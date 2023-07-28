<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Change Password</title>
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
<%--<h1>Change Password</h1>--%>
<form:form action="store-changePassword" modelAttribute="change-password">
<table>
    <tr>
        <td>
            <fieldset>
                <legend><h2 id="ldesign">Change Password</h2></legend>
                <table>
                    <tr>
                        <th>
                            <label for="username">Username:</label>
                        </th>
                        <td>
                            <form:input path="username" id="username"/>
                        </td>
                        <td>
                            <form:errors path="username"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="current_password">Current Password:</label>
                        </th>
                        <td>
                            <form:input path="current_password" id="current_password"/>
                        </td>
                        <td>
                            <form:errors path="current_password"/>
                        </td>
                    </tr>
                     <tr>
                        <th>
                            <label for="new_password">New Password:</label>
                        </th>
                        <td>
                            <form:input path="new_password" id="new_password"/>
                        </td>
                        <td>
                            <form:errors path="new_password"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
     <tr>
           <td align="center">
               <input type="submit" value="Update">
           </td>
    </tr>
</table>
</form:form>
</div>
</body>
</html>
