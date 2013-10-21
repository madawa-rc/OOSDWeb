<%@page import="slomf.registration.Student"%>
<%@page import="slomf.registration.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : schoolDashboard
    Created on : 23-Sep-2013, 21:36:04
    Author     : Madawa
--%>
<%

    ArrayList<Student> studentList = null;
    School s = null;
    try {
        s = (School) session.getAttribute("schoolObject");
        studentList = s.getStudentList();
    } catch (Exception ex) {
        response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in!");
    }
    User user = (User) session.getAttribute("user");
%>
<%@page import="java.util.ArrayList"%>
<%@page import="slomf.registration.School"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>IN ADMIN PANEL | Powered by INDEZINER</title>        
        <link rel="shortcut icon" href="images/logo.png"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="css/clockp.js"></script>
        <script type="text/javascript" src="css/clockh.js"></script> 
        <script type="text/javascript" src="css/jquery.min.js"></script>
        <script type="text/javascript" src="css/ddaccordion.js"></script>
        <script type="text/javascript">
            ddaccordion.init({
                headerclass: "submenuheader", //Shared CSS class name of headers group
                contentclass: "submenu", //Shared CSS class name of contents group
                revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
                mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
                collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
                defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
                onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
                animatedefault: false, //Should contents open by default be animated into view?
                persiststate: true, //persist state of opened contents within browser session?
                toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
                togglehtml: ["suffix", "<img src='css/images/plus.gif' class='statusicon' />", "<img src='css/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
                animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
                oninit: function(headers, expandedindices) { //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose: function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
                    //do nothing
                }
            })
        </script>

        <script type="text/javascript" src="css/jconfirmaction.jquery.js"></script>
        <script type="text/javascript">

            $(document).ready(function() {
                $('.ask').jConfirmAction();
            });

        </script>

        <script language="javascript" type="text/javascript" src="css/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="css/niceforms-default.css" />
        <script type="text/javascript">
            function message() {
                var result = confirm("You are violating the honour code pledge!\nAre you really want to do this?");
                return result;
            }

            function addRow(tableID) {
                var n = document.getElementById("num").value;
                n = parseInt(n);
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);

                var element1 = document.createElement("input");
                element1.type = "hidden";
                element1.value = n + 1;


                var element2 = document.createElement("input");
                element2.type = "text";
                element2.id = "student" + (n + 1);
                element2.name = "student" + (n + 1);
                element2.required = "true";
                element2.value = "";
                cell1.appendChild(element2);
                cell1.appendChild(element1);

                var element5 = document.createElement("select");
                element5.id = "date" + (n + 1);
                element5.name = "date" + (n + 1);
                element5.required = "true";
                nul5 = document.createElement("option");
                nul5.value = "";
                nul5.text = "Select";
                nul5.style.display = "none";
                element5.appendChild(nul5);

                for (var i = 1; i < 32; i++) {
                    opt = document.createElement("option");
                    opt.value = i;
                    opt.text = i;
                    element5.appendChild(opt);
                }
                cell2.appendChild(element5);

                var element6 = document.createElement("select");
                element6.id = "month" + (n + 1);
                element6.name = "month" + (n + 1);
                element6.required = "true";
                nul6 = document.createElement("option");
                nul6.value = "";
                nul6.text = "Select";
                nul6.style.display = "none";
                element6.appendChild(nul6);

                for (var i = 1; i < 13; i++) {
                    opt = document.createElement("option");
                    opt.value = i;
                    opt.text = i;
                    element6.appendChild(opt);
                }
                cell2.appendChild(element6);

                var element7 = document.createElement("select");
                element7.id = "year" + (n + 1);
                element7.name = "year" + (n + 1);
                element7.required = "true";
                nul7 = document.createElement("option");
                nul7.value = "";
                nul7.text = "Select";
                nul7.style.display = "none";
                element7.appendChild(nul7);

                for (var i = 1994; i < 2011; i++) {
                    opt = document.createElement("option");
                    opt.value = i;
                    opt.text = i;
                    element7.appendChild(opt);
                }
                cell2.appendChild(element7);

                var element8 = document.createElement("select");
                element8.id = "medium" + (n + 1);
                element8.name = "medium" + (n + 1);
                element8.required = "true";
                nul8 = document.createElement("option");
                nul8.value = "";
                nul8.text = "Select";
                nul8.style.display = "none";
                element8.appendChild(nul8);

                for (var i = 0; i < 3; i++) {
                    opt = document.createElement("option");
                    if (i == 0)
                        str = "SINHALA";
                    else if (i == 1)
                        str = "ENGLISH";
                    else
                        str = "TAMIL";
                    opt.value = str;
                    opt.text = str;
                    element8.appendChild(opt);
                }
                cell3.appendChild(element8);
                document.cre
                var element3 = document.createElement('A');

                var cacheImage = document.createElement('img');
                cacheImage.src = 'css/images/trash.png';
                element3.appendChild(cacheImage);
                element3.type = "link";
                element3.value = "Delete";
                element3.onclick = function() {
                    deleteRow(tableID, n + 1);
                };
                cell3.appendChild(element3);

                document.getElementById("num").value = n + 1;


            }


            function deleteRow(tableID, rw) {
                var x = window.confirm("Are you sure you want to delete this row?")
                if (x)
                {
                    var Num = parseInt(rw);
                    try {
                        var table = document.getElementById(tableID);
                        var rowCount = table.rows.length;
                        for (var i = 1; i < rowCount; i++) {
                            var row = table.rows[i].cells[0].childNodes[1].value;
                            if (null != row && row == Num) {
                                document.getElementById("medium" + Num).value = "deleted";
                                table.deleteRow(i);
                                rowCount = table.rows.length;
                                //  if (rowCount > 2)
                                //      table.rows[rowCount - 1].cells[2].childNodes[2].style.display = "";
                                break;
                            }
                        }

                    } catch (e) {
                        alert(e);
                    }
                }
            }
        </script>

    </head>

    <body>
        <div id="main_container">

            <div class="header">
                <div class="logo"><a href="#"><img src="css/images/logo.png" alt="" title="" border="0" /></a></div>
                    <%
                        if (user != null) {
                    %>
                <div class="right_header">Welcome Back! <a href="#">My Account</a> | <a href="#">Settings</a> | 
                    <a href = "logout.jsp" class ="logout">Logout</a>
                </div>
                <%                    }
                %>
                <div id="clock_a"></div>
            </div>


            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a href="./">Home</a></li>
                        <li><a href="news.jsp">News</a></li>
                        <li><a href="#">Register</a>
                            <ul>
                                <li><a href="studentRegistration.jsp" title="">As a Private Applicant</a></li>
                                <li><a href="schoolRegistration.jsp" title="">As a School</a></li>
                            </ul>
                        </li>
                        <li><a href="login.jsp">Login</a></li>
                            <% if (user != null) {
                            %>
                        <li><a class="current" href="<%=user.getLink()%>">Dashboard</a>
                        </li>
                        <%}%>
                        <li><a href="contactUs.jsp">Contact us</a></li>
                    </ul>
                </div>
                <div class="center_content">
                    <%@ include file="userLeftBar.jsp" %>

                    <div class="right_content">            

                        <h2>Registered Students</h2> 
                        <form name="myform" action="SchoolModifyServlet" method="post">


                            <INPUT type="hidden" value=<%=studentList.size()%> id="num" name ="num" required="true"/>
                            <INPUT type="hidden" value=<%=studentList.size()%> id="num2" name ="num2" required="true"/>
                            <INPUT type="hidden" value=<%=s.getEmail()%> id="email" name ="email" required="true"/>
                            <table id="rounded-corner">
                                <thead>
                                    <tr>
                                        <th scope="col" class="rounded">Name</th>
                                        <th scope="col" class="rounded">Date of Birth</th>
                                        <th scope="col" class="rounded">Medium</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        if (studentList != null)
                                            for (int i = 0; i < studentList.size(); ++i) {
                                    %>

                                    <tr>
                                        <td>
                                            <INPUT type="hidden" value=<%=String.valueOf(i + 1)%> />              
                                            <INPUT type="text" value="<%=studentList.get(i).getName()%>" id=<%="student" + String.valueOf(i + 1)%> name=<%="student" + String.valueOf(i + 1)%> required="true"/> 
                                        </td>
                                        <td>

                                            <select name=<%="date" + String.valueOf(i + 1)%> required="true">
                                                <option value="<%= studentList.get(i).getDate()%>" style="display:none"><%=studentList.get(i).getDate()%></option>
                                                <%
                                                    for (int j = 1; j < 32; ++j) {
                                                        out.print("<option value=\"" + j + "\">" + j + "</option>");
                                                    }
                                                %>
                                            </select>
                                            <select name=<%="month" + String.valueOf(i + 1)%> required="true">
                                                <option value="<%=studentList.get(i).getMonth()%>" style="display:none"><%=studentList.get(i).getMonth()%></option>
                                                <%
                                                    for (int j = 1; j < 13; ++j) {
                                                        out.print("<option value=\"" + j + "\">" + j + "</option>");
                                                    }
                                                %>
                                            </select>
                                            <select name=<%="year" + String.valueOf(i + 1)%> required="true">
                                                <option value="<%=studentList.get(i).getYear()%>" style="display:none"><%=studentList.get(i).getYear()%></option>
                                                <%
                                                    for (int j = 1994; j < 2011; ++j) {
                                                        out.print("<option value=\"" + j + "\">" + j + "</option>");
                                                    }
                                                %>
                                            </select>
                                        </td>
                                        <td>
                                            <select name =<%="medium" + String.valueOf(i + 1)%>  id = <%="medium" + String.valueOf(i + 1)%>  required="true">
                                                <option value="<%=studentList.get(i).getMedium()%>" style="display:none"><%=studentList.get(i).getMedium()%></option>
                                                <option value="ENGLISH">ENGLISH</option>;
                                                <option value="SINHALA">SINHALA</option>;
                                                <option value="TAMIL">TAMIL</option>;        
                                            </select>

                                            <INPUT type="hidden" value=<%=studentList.get(i).getId()%> name=<%="studentId" + String.valueOf(i + 1)%> />
                                            <a href="#" class="ask"  onclick="deleteRow('rounded-corner', '<%=String.valueOf(i + 1)%>');">
                                                <img src="css/images/trash.png" border="0" />
                                            </a>
                                        </td>
                                    </tr>
                                    <% }%>        
                                </tbody>
                            </table>
                            <br></br>
                            <INPUT type="button" value="Add Student" onclick="addRow('rounded-corner')" class="button"/> 
                            <input type="submit" value="Submit" class="button"/>

                        </form>
                    </div><!-- end of right content-->
                </div>   <!--end of center content -->        
                <div class="clear"></div>
            </div> <!--end of main content-->
            <div class="footer">
                <div class="left_footer">IN ADMIN PANEL | Powered by <a href="http://indeziner.com">INDEZINER</a></div>
                <div class="right_footer"><a href="http://indeziner.com"><img src="css/images/fiontar.png" alt="" title="" border="0" /></a></div>
            </div>
        </div>		
    </body>
</html>