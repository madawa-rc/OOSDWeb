<%-- 
    Document   : answerSheet
    Created on : Oct 7, 2013, 10:04:24 PM
    Author     : Fiontar
--%>

<%@page import="slmo.registration.User"%>
<%@page import="slmo.registration.ResultSheet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Answer Sheet</title>
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
    <script language="javascript">
        function isNumberKey(evt) {
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }
    </script>
    <%
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getName().equals("Admin")) {
            request.getSession().removeAttribute("user");
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Admin!");
        } else {
            ResultSheet resultSheet = null;
            try {
                resultSheet = (ResultSheet) session.getAttribute("resultSheet");
            } catch (Exception ex) {
            }
    %>
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
                                    <li><a href="contactUs.jsp">Contact us</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </header>
        </div>
        <div id="wrapper">
            <div id="page">
                <div class="">
                    <div class="">
                        <div class="" id="">
                            <section>
                                <div class="post">
                                </div>
                            </section>
                            <div style= "width:600px; margin:auto;">
                                <div class="box-2">
                                    <p><strong>
                                            <font size="+2">Administrator Dashboard</font>
                                            <br><br>
                                        </strong></p>
                                    <form name="searchForm" method="post" action="GetAnswerScript" id="ContactForm">
                                        <p class="para">&nbsp;Search:</font> &nbsp;&nbsp; 
                                            <input class="input" type="text" value="Index number"
                                                   onBlur="if (this.value == '')
                this.value = 'Index number'"
                                                   onFocus="if (this.value == 'Index number')
                this.value = ''" name="indexNum" onkeypress="return isNumberKey(event)">
                                            <input type="submit" value="Search" class="button">
                                        </p>
                                    </form>

                                    <%
                                        if (resultSheet != null) {
                                            String[] rs = resultSheet.getRecords();
                                            String styleStart = "<font size=4><strong>";
                                            String styleEnd = "</font></strong>";
                                            out.print(styleStart + "Name: " + styleEnd + resultSheet.getName() + "<br>");
                                            out.print(styleStart + "School: " + styleEnd + resultSheet.getSchool() + "<br>");
                                            out.print(styleStart + "Index: " + styleEnd + resultSheet.getIndexNum() + "<br>");
                                            out.print(styleStart + "Examination centre: " + styleEnd + resultSheet.getAssignedCentre() + "<br><br>");
                                            for (int i = 0; i < 30; ++i) {
                                    %>
                                    <img src="<% out.print("images/score/" + rs[i] + ".jpg");%>">
                                    <%
                                                if (i == 14) {
                                                    out.print("<br><br>");
                                                }
                                            }
                                            out.print("<br><br><a href=\"GetAnswerScript?next=true\" align=\"center\">Next</a>");
                                        }
                                    %>
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