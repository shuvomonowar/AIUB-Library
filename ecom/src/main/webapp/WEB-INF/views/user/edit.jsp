<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
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
<body>
<jsp:include page="../portal/welcome.jsp" />
<br>
<br>
<br>
<%--<h1>Edit User</h1>--%>
<div align="center">
<form:form action="update" modelAttribute="user">
    <form:hidden path="id" readonly="true"/>
    <form:errors path="id"/>
    <table>
        <tr>
            <td>
                <fieldset>
                    <legend><h2 id="ldesign">Edit Profile</h2></legend>
                    <table>
                        <tr>
                            <th>
                                <label for="fullName">Full Name:</label>
                            </th>
                            <td>
                                <form:input path="fullName" id="fullName"/>
                            </td>
                            <td>
                                <form:errors path="fullName"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="username">Username:</label>
                            </th>
                            <td>
                                <form:input path="username" id="username" readonly="true"/>
                            </td>
                            <td>
                                <form:errors path="username"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="dob">Date Of Birth:</label>
                            </th>
                            <td>
                                <form:input type="date" path="dateOfBirth" id="dob"/>
                            </td>
                            <td>
                                <form:errors path="dateOfBirth"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="gender">Gender:</label>
                            </th>
                            <td>
                                <form:radiobutton path="gender" id="gender" value="MALE"/>MALE
                            </td>
                            <td>
                                <form:radiobutton path="gender" id="gender" value="FEMALE"/>FEMALE
                            </td>
                            <td>
                                <form:errors path="gender"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="email">Email:</label>
                            </th>
                            <td>
                                <form:input type="email" path="email" id="email"/>
                            </td>
                            <td>
                                <form:errors path="email"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
         <tr>
            <td align="center">
                <input type="submit" value="Update">
                <a href="${pageContext.request.contextPath}/users/portal"><button class="buttonUpBack">Back</button></a>
            </td>
        </tr>
    </table>
    <form:hidden path="password" readonly="true"/>
    <form:errors path="password"/>
</form:form>
</body>
</html>
