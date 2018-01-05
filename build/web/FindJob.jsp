<%-- 
    Document   : FindJob
    Created on : Dec 23, 2017, 8:52:56 PM
    Author     : Thinh Phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/CSS/header.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/newcss.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/findjob.css">
        <link rel="stylesheet" type="text/css" href="styles/CSS/job.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <section class="header">
            <div class header-contents>
                <a class="logo" href="index.html">
                    <img src="styles/Images/logo_small.png">
                </a>

                <nav class="nav">
                    <li class="nav__itembox"> <a class="nav__items" href="Student.jsp">Profile</a> </li>
                    <li class="nav__itembox"> <a class="nav__itemsred" href="FindJob.jsp">Find Jobs</a> </li>			
                    <li class="nav__itembox"> <a class="nav__items" href="index.html">Signout</a> </li>
                </nav>
            </div>
        </section>
        <form></form>
        <table border="2" id="tb">
            <tr>
                <th>Title</th>
                <th>Employer</th>
                <th>Salary</th>
                <th>Expiry</th>
                <th>Skill 1</th>
                <th>Skill 2</th>
                <th>Skill 3</th>
                <th>Apply</th>
            </tr>

        </table>
        <button type="button" onclick="showMore()">Show More</button>
        <form action="">
            <input type="radio"  name="filter" value="1"> Less than 125 $<br>
            <input type="radio"  name="filter" value="2"> More than 125 $<br>
            <input type="radio"  name="filter" value="0" checked=""> All
            <button type="button" onclick="filtering()">Filter</button>
        </form>

        <label>There are ${day} student(s) accepted for a job today</label><br>
        <label>There are ${month} student(s) accepted for a job in this month</label><br>
        <label>Recommend job for you</label>
        
        <div id="post" class="post">
            <label>Title:</label>
            <label>${jobR.title}</label><br>
            <label>Salary</label>
            <label>${jobR.salary}</label><br>
            <form action="FindJobServlet">
                <input type="hidden" name="action" value="apply">
                <input type="hidden" name="id" value="${jobR.id}">
                <input type="submit" value="Apply">
            </form>
            
            <button type="button" onclick="document.getElementById('post').style.display = 'none'" class="cancelbtn">Cancel</button>
        </div>
            <button onclick="document.getElementById('post').style.display = 'block'">View</button>
        
        
        <script type="text/javascript">
//            
            var d, f1 = [], f2 = [];
            $(document).ready(function () {
//                $.getJSON('data.json', function (data) {
//                    var v = '';
//                    $.each(data, function (key, value) {
//                        v += '<tr>';
//                        v += '<td>' + value.title + '</td>';
//                        v += '<td>' + value.employer + '</td>';
//                        v += '<td>' + value.salary + '</td>';
//                        v += '<td>' + value.expiry + '</td>';
//                        v += '<td>' + value.skill1 + '</td>';
//                        v += '<td>' + value.skill2 + '</td>';
//                        v += '<td>' + value.skill3 + '</td>';
//                        v += '</tr>';
//                    });
//                    $('#tb').append(v);
//                });

                var i = 0;

                $.ajax({
                    type: 'GET',
                    url: 'data.json',
                    success: function (data) {
                        var v = '';
                        d = data;
                        for (k = 0; k < d.length; k++) {
                            if (d[k].salary <= 125) {
                                f1.push(d[k]);
                            } else {
                                f2.push(d[k]);
                            }
                        }
                        $.each(data, function (index, value) {
                            v += '<tr>';
                            v += '<td>' + value.title + '</td>';
                            v += '<td>' + value.employer + '</td>';
                            v += '<td>' + value.salary + '</td>';
                            v += '<td>' + value.expiry + '</td>';
                            v += '<td>' + value.skill1 + '</td>';
                            v += '<td>' + value.skill2 + '</td>';
                            v += '<td>' + value.skill3 + '</td>';
                            v += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                    "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                    "<input type=\"hidden\" name=\"id\" value=\"" + data[i].id + "\">" +
                                    "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                            v += '</tr>';
                        });

                        $('#tb').append(v);


                    }
                });



            });

            function filtering() {
                var i = $('input[name=filter]:checked').val();
                var z;
                while ($('#tb tr').length > 1) {
                    document.getElementById('tb').deleteRow(1);
                }



                var v = '';
                if (i == 1) {
                    for (l = 0; l < 2; l++) {
                        v += '<tr>';
                        v += '<td>' + f1[l].title + '</td>';
                        v += '<td>' + f1[l].employer + '</td>';
                        v += '<td>' + f1[l].salary + '</td>';
                        v += '<td>' + f1[l].expiry + '</td>';
                        v += '<td>' + f1[l].skill1 + '</td>';
                        v += '<td>' + f1[l].skill2 + '</td>';
                        v += '<td>' + f1[l].skill3 + '</td>';
                        v += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                "<input type=\"hidden\" name=\"id\" value=\"" + f1[l].id + "\">" +
                                "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                        v += '</tr>';
                    }
                    $('#tb').append(v);
                }
                if (i == 2) {
                    for (l = 0; l < 2; l++) {
                        v += '<tr>';
                        v += '<td>' + f2[l].title + '</td>';
                        v += '<td>' + f2[l].employer + '</td>';
                        v += '<td>' + f2[l].salary + '</td>';
                        v += '<td>' + f2[l].expiry + '</td>';
                        v += '<td>' + f2[l].skill1 + '</td>';
                        v += '<td>' + f2[l].skill2 + '</td>';
                        v += '<td>' + f2[l].skill3 + '</td>';
                        v += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                "<input type=\"hidden\" name=\"id\" value=\"" + f2[l].id + "\">" +
                                "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                        v += '</tr>';
                    }
                    $('#tb').append(v);
                }
                if (i == 0) {
                    for (l = 0; l < 2; l++) {
                        v += '<tr>';
                        v += '<td>' + d[l].title + '</td>';
                        v += '<td>' + d[l].employer + '</td>';
                        v += '<td>' + d[l].salary + '</td>';
                        v += '<td>' + d[l].expiry + '</td>';
                        v += '<td>' + d[l].skill1 + '</td>';
                        v += '<td>' + d[l].skill2 + '</td>';
                        v += '<td>' + d[l].skill3 + '</td>';
                        v += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                "<input type=\"hidden\" name=\"id\" value=\"" + d[l].id + "\">" +
                                "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                        v += '</tr>';
                    }
                    $('#tb').append(v);
                }



            }

            function showMore() {
                var i = $('input[name=filter]:checked').val();
                var z = $('#tb tr').length - 1;
                if (i == 0) {
                    if (z < d.length) {
                        var y = '';
                        y += '<tr>';
                        y += '<td>' + d[z].title + '</td>';
                        y += '<td>' + d[z].employer + '</td>';
                        y += '<td>' + d[z].salary + '</td>';
                        y += '<td>' + d[z].expiry + '</td>';
                        y += '<td>' + d[z].skill1 + '</td>';
                        y += '<td>' + d[z].skill2 + '</td>';
                        y += '<td>' + d[z].skill3 + '</td>';
                        y += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                "<input type=\"hidden\" name=\"id\" value=\"" + d[z].id + "\">" +
                                "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                        y += '</tr>';
                        $('#tb').append(y);
                    }
                }
                if (i == 1) {
                    if (z < f1.length) {
                        var y = '';
                        y += '<tr>';
                        y += '<td>' + f1[z].title + '</td>';
                        y += '<td>' + f1[z].employer + '</td>';
                        y += '<td>' + f1[z].salary + '</td>';
                        y += '<td>' + f1[z].expiry + '</td>';
                        y += '<td>' + f1[z].skill1 + '</td>';
                        y += '<td>' + f1[z].skill2 + '</td>';
                        y += '<td>' + f1[z].skill3 + '</td>';
                        y += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                "<input type=\"hidden\" name=\"id\" value=\"" + f1[z].id + "\">" +
                                "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                        y += '</tr>';
                        $('#tb').append(y);
                    }
                }

                if (i == 2) {
                    if (z < f2.length) {
                        var y = '';
                        y += '<tr>';
                        y += '<td>' + f2[z].title + '</td>';
                        y += '<td>' + f2[z].employer + '</td>';
                        y += '<td>' + f2[z].salary + '</td>';
                        y += '<td>' + f2[z].expiry + '</td>';
                        y += '<td>' + f2[z].skill1 + '</td>';
                        y += '<td>' + f2[z].skill2 + '</td>';
                        y += '<td>' + f2[z].skill3 + '</td>';
                        y += '<td>' + "<form action=\"FindJobServlet\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"action\" value=\"apply\">" +
                                "<input type=\"hidden\" name=\"id\" value=\"" + f2[z].id + "\">" +
                                "<input type=\"submit\" id=\"a\" value=\"Apply\"></form>" + '</td>';
                        y += '</tr>';
                        $('#tb').append(y);
                    }

                }

            }
        </script>
    </body>
</html>
