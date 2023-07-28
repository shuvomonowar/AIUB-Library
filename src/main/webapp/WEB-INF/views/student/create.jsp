<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create New Student</title>
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
<%--<h1>Create New Student</h1>--%>
<form:form action="store" modelAttribute="student">
<table>
    <tr>
        <td>
            <fieldset>
                <legend><h2 id="ldesign">Edit Student Information</h2></legend>
                <table>
                        <tr>
                            <th>
                                <label for="student_name">Student Name:</label>
                            </th>
                            <td>
                                <form:input path="student_name" id="student_name"/>
                            </td>
                            <td>
                                 <form:errors path="student_name"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="academic_program">Academic Program:</label>
                            </th>
                            <td>
                                <form:select path="academic_program" id="academic program">
                                    <form:option value=""/> -Select-
                                    <form:option value="BSc CSE"/>BSc CSE
                                    <form:option value="MSc CSE"/>MSc CSE
                                    <form:option value="BSc EEE"/>BSc EEE
                                    <form:option value="MSc EEE"/>MSc EEE
                                    <form:option value="BA English"/>BA English
                                    <form:option value="MA English"/>MA English
                                    <form:option value="LLB"/>LLB
                                    <form:option value="LLM"/>LLM
                                    <form:option value="BBA"/>BBA
                                    <form:option value="MBA"/>MBA
                                </form:select>
                            </td>
                            <td>
                                <form:errors path="academic_program"/>
                            </td>
                        </tr>
                    </tr>
                    <tr>
                        <th>
                            <label for="status">Status:</label>
                        </th>
                        <td>
                            <form:select path="status" id="status">
                                <form:option value=""/> -Select-
                                <form:option value="Valid"/>Valid
                                <form:option value="Invalid"/>Invalid
                            </form:select>
                        </td>
                        <td>
                            <form:errors path="status"/>
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
<a href="${pageContext.request.contextPath}/students/list"><button class="buttonUpBack">Back</button></a>
</div>
</body>
</html>
