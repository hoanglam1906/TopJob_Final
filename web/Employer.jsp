<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Employer
    Created on : Dec 20, 2017, 8:45:11 AM
    Author     : Thinh Phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta author="Hoàng Tùng Lâm" content="Bài tập lớn">
        <link rel="stylesheet" type="text/css" href="styles/CSS/header.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/employer.css">
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
                    <li class="nav__itembox"> <a class="nav__itemsred" href="Employer.jsp">Profile</a> </li>
                    <li class="nav__itembox"> <a class="nav__items" href="job.jsp">Jobs</a> </li>	
                    <li class="nav__itembox"> <a class="nav__items" href="index.html">Signout</a> </li>
                </nav>
            </div>
        </section>
        
        <form action="EmProServlet" method="post">
            <input type="hidden" name="action" value="ok">
            <label>Full name</label>
            <input type="text" name="name" value="<c:out value='${employer.name}'/>" required>
            <label>Company</label>
            <input type="text" name="company" value="<c:out value='${employer.company}'/>" required>
            <input type="submit" value="Save">
        </form>
    
    </body>
</html>