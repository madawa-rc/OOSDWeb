<%-- 
    Document   : centerStatistics
    Created on : 10-Oct-2013, 15:45:00
    Author     : Danula
--%>

<%@page import="slmo.centerallocation.CenterAllocation"%>
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
            int[][] preferredCenters = CenterAllocation.getPreferredCenterStats();
            int[][] assignedCenters = CenterAllocation.getAssignedCenterStats();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Center Statistics</title>
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
                                    <div style= "width:800px; margin:auto;">
                                        <div class="box-2">
                                            <p><center><strong>
                                                    <font size="+2">Center Statistics</font>
                                                    <br><br>
                                                </strong></center></p>



                                            <div class="StudentData">
                                                <table id="dataTable" width="100px" border="0">
                                                    <tr>
                                                        <td>
                                                            Preferred Center
                                                        </td>
                                                        <td >
                                                            Sinhala
                                                        </td>
                                                        <td>
                                                            English
                                                        </td>
                                                        <td>
                                                            Tamil
                                                        </td>
                                                        <td>
                                                            Total
                                                        </td>
                                                    </tr>
                                                    <%
                                                        if (preferredCenters != null) {
                                                            for (int i = 0; i < CenterAllocation.preferredCenters.length + 1; i++) {
                                                    %>
                                                    <tr>
                                                        <td>
                                                            <%
                                                                if (i == CenterAllocation.preferredCenters.length) {
                                                            %>
                                                            <b>TOTAL</b>
                                                            <%                                    } else {
                                                            %>
                                                            <label><%=CenterAllocation.preferredCenters[i]%></label>
                                                            <%
                                                                }
                                                            %>
                                                        </td>
                                                        <td>
                                                            <label><%=preferredCenters[i][0]%></label>                                
                                                        </td>
                                                        <td>
                                                            <label><%=preferredCenters[i][1]%></label>
                                                        </td>
                                                        <td>
                                                            <label><%=preferredCenters[i][2]%></label>
                                                        </td>
                                                        <td>
                                                            <label><%=preferredCenters[i][3]%></label>
                                                        </td></tr>
                                                        <%
                                                                }//end of for    
                                                            }//end of if
%>
                                                </table>
                                                <br>
                                                <br>
                                                <table id="dataTable2" width="100px" border="0">
                                                    <tr>
                                                        <td>
                                                            Assigned Center
                                                        </td>
                                                        <td >
                                                            Sinhala
                                                        </td>
                                                        <td>
                                                            English
                                                        </td>
                                                        <td>
                                                            Tamil
                                                        </td>
                                                        <td>
                                                            Total
                                                        </td>
                                                    </tr>
                                                    <%
                                                        if (assignedCenters != null) {
                                                            for (int i = 0; i < CenterAllocation.assignedCenters.length + 1; i++) {
                                                    %>
                                                    <tr>
                                                        <td>
                                                            <%
                                                                if (i == CenterAllocation.assignedCenters.length) {
                                                            %>
                                                            <b>TOTAL</b>
                                                            <%                                    } else {
                                                            %>
                                                            <label><%=CenterAllocation.assignedCenters[i]%></label>
                                                            <%
                                                                }
                                                            %>

                                                        </td>
                                                        <td>
                                                            <label><%=assignedCenters[i][0]%></label>                                
                                                        </td>
                                                        <td>
                                                            <label><%=assignedCenters[i][1]%></label>
                                                        </td>
                                                        <td>
                                                            <label><%=assignedCenters[i][2]%></label>
                                                        </td>
                                                        <td>
                                                            <label><%=assignedCenters[i][3]%></label>
                                                        </td>
                                                    </tr>
                                                    <%      }//end of for
                    }//end of if
%>
                                                </table>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="3u" id="sidebar2">
                                        <section>
                                            <div class="sbox1"></div>
                                        </section>
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
