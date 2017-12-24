<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jobs
    Created on : Dec 20, 2017, 9:38:06 AM
    Author     : Thinh Phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="styles/CSS/header.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/employer.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/newcss.css">
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
        <!-- <meta http-equiv="refresh" content="3" > -->
        <link rel="icon" href="styles/Images/logo.png">
        <title>Employer | TopJob</title>
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
                    <li class="nav__itembox"> <a class="nav__items" href="Employer.jsp">Profile</a> </li>
                    <li class="nav__itembox"> <a class="nav__itemsred" href="job.jsp">Jobs</a> </li>	
                    <li class="nav__itembox"> <a class="nav__items" href="index.html">Signout</a> </li>
                </nav>
            </div>
        </section>
        <div id="post" class="post">
            <form action="ManJobServlet" method="post">
                <input type="hidden" name="action" value="add">
                <label>Title</label>
                <input type="text" name="title" required><br>
                <label>Salary</label>
                <input type="number" name="salary" required><br>
                <input type="checkbox" name="skill" value="skill1">Skill 1<br>
                <input type="checkbox" name="skill" value="skill2">Skill 2<br>
                <input type="checkbox" name="skill" value="skill3">Skill 3<br>
                <label>Expiry</label>
                <input type="date" name="expiry" required>
                <button type="button" onclick="document.getElementById('post').style.display = 'none'" class="cancelbtn">Cancel</button>
                <input type="submit" value="OK">
            </form>
        </div>
        <button onclick="document.getElementById('post').style.display = 'block'">Post a job</button>

        <table border="2">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Employer</th>
                    <th>Salary</th>
                    <th>Skill1</th>
                    <th>Skill2</th>
                    <th>Skill3</th>
                    <th>Expiry</th>
                    <th></th>
                    <th></th>
                    <th>Application</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="job" items="${jobs}">
                    <tr>
                <form action="ManJobServlet" method="post">
                    <td><input type="text" name="title" value="<c:out value='${job.title}'/>"></td>
                    <td>${job.employer.name}</td>
                    <td><input type="number" name="salary" value="<c:out value='${job.salary}'/>"></td>
                    <td><input type="number" name="skill1" value="<c:out value='${job.skill1}'/>"></td>
                    <td><input type="number" name="skill2" value="<c:out value='${job.skill2}'/>"></td></td>
                    <td><input type="number" name="skill3" value="<c:out value='${job.skill3}'/>"></td></td>
                    <td><input type="date" name="expiry" value="<c:out value='${job.expiry}'/>"></td></td>
                    <td>

                        <input type="hidden" name="id" value="<c:out value='${job.id}'/>">
                        <input type="hidden" name="action" value="edit">
                        <input type="submit" value="Edit">
                    </td>
                </form>

                <td>
                    <form action="ManJobServlet" method="post">
                        <input type="hidden" name="id" value="<c:out value='${job.id}'/>">
                        <input type="hidden" name="action" value="delete">
                        <input type="submit" value="Delete">
                    </form>
                </td>

                <td>
                    <form action="ManJobServlet" method="get">
                        <input type="hidden" name="id" value="<c:out value='${job.id}'/>">
                        <input type="hidden" name="action" value="view">
                        <input type="submit" value="View">
                    </form>
                </td>
            </tr>
            
                
        </c:forEach>
    </tbody>
</table>


</body>
</html>
