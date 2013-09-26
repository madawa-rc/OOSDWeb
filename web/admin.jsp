<%-- 
    Document   : schoolDashboard
    Created on : 23-Sep-2013, 21:36:04
    Author     : Madawa
--%>
<%@page import="slmo.registration.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="slmo.registration.School"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <link rel="shortcut icon" href="images/logo.png">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <noscript>
        <link rel="stylesheet" href="css/5grid/core.css" />
        <link rel="stylesheet" href="css/5grid/core-desktop.css" />
        <link rel="stylesheet" href="css/5grid/core-1200px.css" />
        <link rel="stylesheet" href="css/5grid/core-noscript.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/style-desktop.css" />
        </noscript>
        <script src="css/5grid/jquery.js"></script>
        <script src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
    </head>
    <body><div id="header-wrapper">
            <header id="header">
                <div class="5grid-layout">
                    <div class="row">
                        <div class="4u" id="logo">
                            <h1><a href="./" class="mobileUI-site-name">Sri Lanka Mathematics Olympiad</a></h1>
                            <p>by Fiontar</p>
                        </div>
                        <div class="8u" id="menu">
                            <nav class="mobileUI-site-nav">
                                <ul>
                                    <li><a href="./">Home</a></li>
                                    <li><a href="#">News</a></li>
                                    <li><a href="register.jsp">Register</a></li>
                                    <li><a href="login.jsp">Login</a></li>
                                    <li><a href="#">Contact us</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </header>
        </div>
        <div id="wrapper">
            <div class="1u" id="logo">
                <p align="center"><font face="Arial" size="20px"><u>Administrator Dashboard</u></font></p>
            </div>
        </HEAD> 
        <form name="form1" method="post" action="">
            <p class="para">Search:</font> &nbsp;&nbsp; 
                <input class="input" type="text" value="Enter name of the school"
                       onBlur="if(this.value=='') this.value='Enter name of the school'"
                       onFocus="if(this.value =='Enter name of the school' ) this.value=''" >
                <input name="search" type="submit" value="Search" class="button">
            </p>
        </form>
        <br><br>
        <%
            School s = (School) request.getAttribute("schoolObject");
            ArrayList<Student> studentList = null;
            if (s != null) {
                studentList = s.getStudentList();
        %>
        <div class="StudentData" >
            <table id="dataTable" width="350px" border="0">
                <tr>
                    <td>
                        Name
                    </td>
                    <td >
                        Date of birth
                    </td>
                    <td>
                        Medium
                    </td>
                </tr>

                <%
                    if (studentList != null)
                        for (int i = 0; i < studentList.size(); ++i) {
                %>

                <tr>
                    <td >
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
                        <INPUT type="button" value="Delete" onclick="deleteRow('dataTable','<%=String.valueOf(i + 1)%>');" />
                    </td>
                </tr>
                <% }%>
            </table>

        </div>
        <% }%>
        <br><br>

        <p class="para" align="right"><font size="5px">Follow Us:</font></p>
        <ul class="social-list">
            <li><a href="#"><img src="images/social-link-1.jpg" alt=""></a></li>
            <li><a href="https://www.facebook.com/photo.php?fbid=531306523587668&set=pb.285656058152717.-2207520000.1380090385.&type=3&theater"><img src="images/social-link-2.jpg" alt=""></a></li>
            <li><a href="#"><img src="images/social-link-3.jpg" alt=""></a></li>
            <li><a href="#"><img src="images/social-link-4.jpg" alt=""></a></li>
        </ul>
    </div>
    <div>
        <div class="5grid-layout" id="copyright">
            <div class="row">
                <div class="12u">
                    <p>Sri Lanka Mathematics Olympiad Foundation | 2013.09.21 | Contact: +94 71 546 517 8</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
