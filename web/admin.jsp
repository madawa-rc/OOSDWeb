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
        <title>Administrator</title>
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
    <%
        ArrayList<School> list;
        list = (ArrayList<School>) request.getAttribute("schoolList");
    %>
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
                                    <li><a href="contactUs.jsp">Contact us</a></li>
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

            <form name="searchForm" method="post" action="AdminServlet">
                <p class="para">Search:</font> &nbsp;&nbsp; 
                    <input class="input" type="text" value="Enter name of the school"
                           onBlur="if (this.value == '')
                               this.value = 'Enter name of the school'"
                           onFocus="if (this.value == 'Enter name of the school')
                               this.value = ''" name="search">
                    <input type="submit" value="Search" class="button">
                </p>
            </form>
            <br><br>
            <form name="getSchool" method="post" action="AdminServlet">
                <input type="hidden" name="schoolEmail" value="" id="schoolEmail">

                <%
                    if (list == null); else if (list.size() == 0)
                        out.print("No match found!");
                    else {%>
                <p class="para">Search Results:</p>
                <%
                    for (int i = 0; i < list.size(); ++i) {
                %>
                <ul><li>
                        <br>&nbsp;&nbsp;<a href="<%="AdminServlet?schoolEmail=" + list.get(i).getEmail()%>" target="new"><%out.print(list.get(i).getName());%></a>
                    </li>
                </ul>
                <%}
                    }%>
            </form>
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
</html>
