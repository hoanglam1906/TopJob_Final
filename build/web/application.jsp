<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : application
    Created on : Dec 23, 2017, 11:06:36 AM
    Author     : Thinh Phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Application</title>
        <link rel="stylesheet" type="text/css" href="styles/CSS/header.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/employer.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/job.css">
    </head>
    <body>
        <section class="header">
            <div class header-contents>
                <a class="logo" href="index.html">
                    <img src="styles/Images/logo_small.png">
                </a>

                <nav class="nav">
                    <li class="nav__itembox"> <a class="nav__items" href="Employer.jsp">Profile</a> </li>
                    <li class="nav__itembox"> <a class="nav__itemsred" href="job.jsp">Jobs</a> </li>	
                    <li class="nav__itembox"> <a class="nav__items" href="index.html">Signout</a> </li>
                </nav>
            </div>
        </section>
        <div class="nav_replace">
            <li class="nav__itemboxnew"> <a class="nav__items" href="Employer.jsp">Profile</a> </li>
            <li class="nav__itemboxnew"> <a class="nav__itemsred" href="job.jsp">Jobs</a> </li>
            <li class="nav__itemboxnew"> <a class="nav__items" href="index.html">Signout</a> </li>
            
        </div>
        <form></form>
        <label><b>Job's title: <b></label>
        <label><b>${title}<b></label>
        <table border="2">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>School</th>
                    <th>Skill 1</th>
                    <th>Skill 2</th>
                    <th>Skill 3</th>
                    <th>Option</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${application.students}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.school}</td>
                    <td>${student.skill1}</td>
                    <td>${student.skill2}</td>
                    <td>${student.skill3}</td>
                    <td>
                        <form action='ManJobServlet' method="post">
                            <input type="hidden" name="action" value="accept">
                            <input type="hidden" name="email" value="${student.account.email}">
                            <input type="submit" value="Accept and get Email">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table><br><br>
        <label>Accepted Student</label>
        <table border="2">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>School</th>
                    <th>Skill 1</th>
                    <th>Skill 2</th>
                    <th>Skill 3</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${listS}">
                    <tr>
                        <td>${s.student.name}</td>
                        <td>${s.student.school}</td>
                        <td>${s.student.skill1}</td>
                        <td>${s.student.skill2}</td>
                        <td>${s.student.skill3}</td>
                        <td>${s.student.account.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="ManJobServlet" method="post">
            <input type="hidden" name="action" value="back">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
