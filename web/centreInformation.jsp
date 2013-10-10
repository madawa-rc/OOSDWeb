<%-- 
    Document   : centreInformation
    Created on : 07-Oct-2013, 16:05:00
    Author     : Madawa
--%>

<%@page import="slmo.registration.User"%>
<%@page import="slmo.centerallocation.dao.CenterDA"%>
<%@page import="slmo.centerallocation.ExamCenter"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getName().equals("Admin")) {
            request.getSession().removeAttribute("user");
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Admin!");
        } else {
            ArrayList<ExamCenter> centerList = CenterDA.getAllCenters();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centre Information</title>
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
    <body>
        <div id="header-wrapper">
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
            <div>
                <div id="wrapper">
                    <div id="page">
                        <div class="">
                            <div class="">
                                <div class="" id="">
                                    <section>
                                        <div class="post">
                                        </div>
                                    </section>
                                    <div style= "width:1400px; margin:auto;">
                                        <div class="box-2">
                                            <p><center><strong>
                                                    <font size="+2" >Centre Information</font>
                                                    <br><br>
                                                </strong></center></p>

                                            <form name="centreInfo" action="CenterUpdateServlet" method="post" id="ContactForm">
                                                <input type="hidden" value="<%=centerList.size()%>" id="size" name="size">
                                                <div class="StudentData">
                                                    <table id="dataTable" width="350px" border="0">
                                                        <tr>
                                                            <td>
                                                                Name
                                                            </td>
                                                            <td >
                                                                Location
                                                            </td>
                                                            <td>
                                                                Capacity
                                                            </td>
                                                            <td>
                                                                Classrooms
                                                            </td>
                                                            <td>
                                                                Supervisor
                                                            </td>
                                                            <td>
                                                                Phone
                                                            </td>
                                                        </tr>
                                                        <%
                                                            if (centerList != null) {
                                                                for (int i = 0; i < centerList.size(); i++) {
                                                        %>
                                                        <tr>
                                                            <td>
                                                                <input type="hidden" id="<%="name" + String.valueOf(i + 1)%>" value="<%=centerList.get(i).getCenterName()%>" name="<%="name" + String.valueOf(i + 1)%>" required="true"/>
                                                                <label><%=centerList.get(i).getCenterName()%></label>
                                                            </td>
                                                            <td>
                                                                <input type="text" value="<%=centerList.get(i).getLocation()%>" id="<%="location" + String.valueOf(i + 1)%>" name="<%="location" + String.valueOf(i + 1)%>" required="true"/>
                                                            </td>
                                                            <td>
                                                                <input type="text" value="<%=centerList.get(i).getCapacity()%>" id="<%="capacity" + String.valueOf(i + 1)%>" name="<%="capacity" + String.valueOf(i + 1)%>" required="true"/>
                                                            </td>
                                                            <td>
                                                                <input type="text" value="<%=centerList.get(i).getClassrooms()%>" id="<%="classrooms" + String.valueOf(i + 1)%>" name="<%="classrooms" + String.valueOf(i + 1)%>" required="true"/>
                                                            </td>
                                                            <td>
                                                                <input type="text" value="<%=centerList.get(i).getSupervisor()%>" id="<%="supervisor" + String.valueOf(i + 1)%>" name="<%="supervisor" + String.valueOf(i + 1)%>" required="true"/>
                                                            </td>
                                                            <td>
                                                                <input type="text" value="<%=centerList.get(i).getPhone()%>" id="<%="phone" + String.valueOf(i + 1)%>" name="<%="phone" + String.valueOf(i + 1)%>" required="true"/>
                                                            </td>
                                                        </tr>
                                                        <%      }//end of for
                    }//end of if
%>
                                                    </table>
                                                </div><br><br>
                                                <div class="ButtonAlign">
                                                    <input type="submit" value="Update All" class="button">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>	            
                            </div>
                        </div>
                    </div>
                    <p class="para" align="right"><font size="5px">Follow Us:</font></p>
                    <ul class="social-list">
                        <li><a href="#"><img src="images/social-link-1.jpg" alt=""></a></li>
                        <li><a href="https://www.facebook.com/photo.php?fbid=531306523587668&set=pb.285656058152717.-2207520000.1380090385.&type=3&theater" target="new"><img src="images/social-link-2.jpg" alt=""></a></li>
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
                <%
                    }
                %>
                </html>
