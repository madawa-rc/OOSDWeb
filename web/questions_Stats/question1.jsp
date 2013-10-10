<%-- 
    Document   : question1
    Created on : 10-Oct-2013, 11:30:42
    Author     : Madawa
--%>

<%@page import="slmo.results_processing.Marks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question1 Statistics</title>
        <base href="http://localhost:8080/OOSDWeb/web"/>
        <link rel="shortcut icon" href="images/logo.png">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <noscript>
        <link rel="stylesheet" href="css/5grid/core.css" />
        <link rel="stylesheet" href="css/5grid/core-desktop.css" />
        <link rel="stylesheet" href="css/5grid/core-1200px.css" />
        <link rel="stylesheet" href="css/5grid/core-noscript.css" />
        <link rel="stylesheet" href="css/style-desktop.css" />
        </noscript>
        <script src="css/5grid/jquery.js"></script>
        <script src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
        <title>Statistics</title>
        <link rel="shortcut icon" href="images/logo.png">
        <script type="text/javascript" src="//www.google.com/jsapi"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="js/attc.googleCharts.js"></script>
    </head>
    <body>
<script>
        $(document).ready(function(){
        $('#stats').attc();
        $('#correctp1').attc();
        $('#correctp2').attc();
});</script>
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
                <p align="left"><font face="Helvitica" size="7px"><u>Statistics of Q1</u></font></p>
            </div>
        <div class="StudentData">
            <table>
                <tr>
                    <td>Questions</td>
                    <td >Answer A</td>
                    <td>Answer B</td>
                    <td>Answer C</td>
                    <td>Answer D</td>
                    <td>Answer E</td>
                    <td>Unanswered</td>
                    <td> Multiple Answers</td>
                    <td> Correct Answers</td>
                    <td>Correct Percentage from All Students</td>
                    <td>Correct Percentage from Attempted Students</td>
                </tr>
                            <%
                                double[] stats;
                                stats = Marks.getStatistcs(1);
                            %>
                            
                            <tr>
                                <td><%="Q"+1%></td>
                                <td ><%=(int)stats[0]%></td>
                                <td><%=(int)stats[1]%></td>
                                <td><%=(int)stats[2]%></td>
                                <td><%=(int)stats[3]%></td>
                                <td><%=(int)stats[4]%></td>
                                <td><%=(int)stats[5]%></td>
                                <td><%=(int)stats[6]%></td>
                                <td><%=(int)stats[7]%></td>
                                <td><%=stats[8]%></td>
                                <td><%=stats[9]%></td>
                            </tr>
                </table>
        </div>
            <table  title="Answer Distribution" 
                    id="stats" 
                    summary="Description of table" 
                    data-attc-createChart="true"
                    data-attc-colDescription="colDescription" 
                    data-attc-colValues="A,B,C,D,E,unanswered,multiple" 
                    data-attc-location="statsG" 
                    data-attc-hideTable="true" 
                    data-attc-type="column"
                    data-attc-controls='{"showHide":false,"create":false,"chartType":false}'  
                >
                    <thead>
                        <tr>
                            <th id="colDescription">Questions</th>
                            <th id="A">Answer A</th>
                            <th id="B">Answer B</th>
                            <th id="C">Answer C</th>
                            <th id="D">Answer D</th>
                            <th id="E">Answer E</th>
                            <th id="unanswered">Unanswered</th>
                            <th id="multiple">Multiple</th>
                            <th id="correct">Correct Answers</th>
                            <th id="allPercentage">Correct Percentage from All Students</th>
                            <th id="attPercentage">Correct Percentage from Attempted Students</th>
                            <th id="incorrectAll">Wrong answers All</th>
                            <th id="incorrectSttempt">Wrong answers Attempted</th>
                        </tr>         
                    </thead> 
                    <tbody>
                        <tr>
                            <td><%="Q"+1%></td>
                            <td ><%=(int)stats[0]%></td>
                            <td><%=(int)stats[1]%></td>
                            <td><%=(int)stats[2]%></td>
                            <td><%=(int)stats[3]%></td>
                            <td><%=(int)stats[4]%></td>
                            <td><%=(int)stats[5]%></td>
                            <td><%=(int)stats[6]%></td>
                            <td><%=(int)stats[7]%></td>
                            <td><%=stats[8]%></td>
                            <td><%=stats[9]%></td>
                        </tr>
                    </tbody>
                </table>
                        
                <table  title="Correct Percentage from All Students" 
                    id="correctp1" 
                    summary="Description of table" 
                    data-attc-createChart="true"
                    data-attc-colDescription="colDescription" 
                    data-attc-colValues="percentages" 
                    data-attc-location="statscp1" 
                    data-attc-hideTable="true" 
                    data-attc-type="pie"
                    data-attc-controls='{"showHide":false,"create":false,"chartType":false}'  
                >
                    <thead>
                        <tr>
                            <th id="names"></th>
                            <th id="percentages"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                Correct
                            </td>
                            <td>
                                <%=stats[8]%>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Wrong
                            </td>
                            <td>
                                <%=100-stats[8]%>
                            </td>
                        </tr>
                    </tbody>
                    
                </table>
                            
                <table  title="Correct Percentage from Attempted Students" 
                    id="correctp2" 
                    summary="Description of table" 
                    data-attc-createChart="true"
                    data-attc-colDescription="colDescription" 
                    data-attc-colValues="percentages" 
                    data-attc-location="statscp2" 
                    data-attc-hideTable="true" 
                    data-attc-type="pie"
                    data-attc-controls='{"showHide":false,"create":false,"chartType":false}'  
                >
                    <thead>
                        <tr>
                            <th id="names"></th>
                            <th id="percentages"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                Correct
                            </td>
                            <td>
                                <%=stats[9]%>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Wrong
                            </td>
                            <td>
                                <%=100-stats[9]%>
                            </td>
                        </tr>
                    </tbody>
                    
                </table>
                <div id="statsG"></div><br><br>
                <div id="statscp1"></div><br><br>
                <div id="statscp2"></div><br><br>
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
