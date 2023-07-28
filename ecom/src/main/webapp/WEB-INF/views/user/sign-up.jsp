<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Account</title>
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

        #ldesign {
            color: dark;
        }

        input[type=submit] {
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
<div class="header">
    <img src="https://cdn.dribbble.com/users/1303634/screenshots/4736402/icon-3.jpg?compress=1&resize=400x300&vertical=top" alt="American International University" style="width:100px;height:100px;">
    <h3>AIUB Library</h3>
</div>
<br>
<br>
<div align="center">
<%--<h1>Create Account</h1>--%>
<form:form action="store-up" modelAttribute="sign-up">
    <table>
        <tr>
            <td>
                <fieldset>
                    <legend><h2 id="ldesign">Sign Up</h2></legend>
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
                                <form:input path="username" id="username"/>
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
                        <tr>
                            <th>
                                <label for="password">Password:</label>
                            </th>
                            <td>
                                <form:input path="password" id="password"/>
                            </td>
                            <td>
                                <form:errors path="password"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
         <tr>
            <td align="left">
                <input type="submit" value="Sign Up">
            </td>
        </tr>
        <tr>
            <td>
                <p>Already have an account? <a href="${pageContext.request.contextPath}/users/sign-in">Sign In</a></p>
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
