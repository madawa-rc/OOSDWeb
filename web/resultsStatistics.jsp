<%-- 
    Document   : resultsStatistics
    Created on : 09-Oct-2013, 22:31:14
    Author     : Madawa
--%>

<%@page import="slmo.results_processing.Marks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics</title>
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
            <div class="1u" id="logo">
                <p align="left"><font face="Helvitica" size="7px"><u>Statistics</u></font></p>
            </div>
        
            <div class="StudentData">
                <table id="stats" width="350px" border="0">
                            <tr>
                                <td>
                                    Question
                                </td>
                                <td >
                                    Answer A
                                </td>
                                <td>
                                    Answer B
                                </td>
                                <td>
                                    Answer C
                                </td>
                                <td>
                                    Answer D
                                </td>
                                <td>
                                    Answer E
                                </td>
                                <td>
                                    Unanswerd
                                </td>
                                <td>
                                    Multiple Answers
                                </td>
                                <td>
                                    Correct Answers
                                </td>
                                <td>
                                    Correct Percentage from All Students
                                </td>
                                <td>
                                    Correct Percentage from Attempted Students
                                </td>
                            </tr>
                            <%
                                double[] stats;
                                
                                for(int i = 1; i < 31; i++){
                                    stats = Marks.getStatistcs(i);
                                
                            %>
                            <tr>
                                <td>
                                   <%="Question "+i%>
                                </td>
                                <td >
                                    <%=(int)stats[0]%>
                                </td>
                                <td>
                                    <%=(int)stats[1]%>
                                </td>
                                <td>
                                    <%=(int)stats[2]%>
                                </td>
                                <td>
                                    <%=(int)stats[3]%>
                                </td>
                                <td>
                                    <%=(int)stats[4]%>
                                </td>
                                <td>
                                    <%=(int)stats[5]%>
                                </td>
                                <td>
                                    <%=(int)stats[6]%>
                                </td>
                                <td>
                                    <%=(int)stats[7]%>
                                </td>
                                <td>
                                    <%=stats[8]%>
                                </td>
                                <td>
                                    <%=stats[9]%>
                                </td>
                            </tr>
                            <%
                                }//end of for
                            %>
                </table>
            </div><br><br>
            
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
