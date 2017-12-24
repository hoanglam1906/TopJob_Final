<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Student
    Created on : Dec 23, 2017, 2:05:21 PM
    Author     : Thinh Phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta author="Hoàng Tùng Lâm" content="Bài tập lớn">
        <link rel="stylesheet" type="text/css" href="styles/CSS/header.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/student.css">
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
        <!-- <meta http-equiv="refresh" content="3" > -->
        <link rel="icon" href="styles/Images/logo.png">
        <title>Student | TopJob</title>
        <style >
            /**/
        </style>
    </head>
    <body>
        <section class="header">
            <div class header-contents>
                <a class="logo" href="index.html">
                    <img src="styles/Images/logo_small.png">
                </a>

                <nav class="nav">
                    <li class="nav__itembox"> <a class="nav__itemsred" href="Student.jsp">Profile</a> </li>
                    <li class="nav__itembox"> <a class="nav__items" href="FindJob.jsp">Find Jobs</a> </li>			
                    <li class="nav__itembox"> <a class="nav__items" href="index.html">Signout</a> </li>
                </nav>
            </div>
        </section>
        
        <form action="StuProServlet" method="post">
            <input type="hidden" name="action" value="ok">
            <label>Full name</label>
            <input type="text" name="name" value="<c:out value='${student.name}'/>" required><br>
            <label>School</label>
            <input type="text" name="school" value="<c:out value='${student.school}'/>" required><br>
            <input type="checkbox" name="skill" <c:if test="${student.skill1==1}"> checked
                   </c:if> value="skill1">Skill 1<br>
            <input type="checkbox" name="skill" <c:if test="${student.skill2==1}"> checked
                   </c:if> value="skill2">Skill 2<br>
            <input type="checkbox" name="skill" <c:if test="${student.skill3==1}"> checked
                   </c:if> value="skill3">Skill 3<br>
            
            <input type="submit" value="Save">
        </form>
    </body>
</html>