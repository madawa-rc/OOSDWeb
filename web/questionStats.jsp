<%@page import="slmo.results_processing.Marks"%>
<%@page import="slmo.centerallocation.dao.CenterDA"%>
<%@page import="slmo.centerallocation.ExamCenter"%>
<%@page import="slmo.registration.School"%>
<%@page import="java.util.ArrayList"%>
<%@page import="slmo.registration.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : schoolDashboard
    Created on : 23-Sep-2013, 21:36:04
    Author     : Madawa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !user.getName().equals("Admin")) {
        request.getSession().removeAttribute("user");
        response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Admin!");
    } else {
        int qNumber = Integer.parseInt(request.getParameter("qNum"));
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Question Statistics</title>
        <link rel="shortcut icon" href="images/logo.png"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="css/clockp.js"></script>
        <script type="text/javascript" src="css/clockh.js"></script> 
        <script type="text/javascript" src="css/jquery.min.js"></script>
        <script type="text/javascript" src="css/ddaccordion.js"></script>
        <script type="text/javascript" src="//www.google.com/jsapi"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="js/attc.googleCharts.js"></script>
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
                oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
                    //do nothing
                }
            })
        </script>

        <script type="text/javascript" src="css/jconfirmaction.jquery.js"></script>
        <script type="text/javascript">
            
            $(document).ready(function() {
                $('.ask').jConfirmAction();
                
                $('#stats').attc();
                $('#correctp1').attc();
                $('#correctp2').attc();
            });
        </script>

        <script language="javascript" type="text/javascript" src="css/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="css/niceforms-default.css" />
        <script type="text/javascript">
            function message(){
                var result = confirm("Are you really want to do this?");
                return result;
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
                <%                    } else
                        out.print("<div class=\"right_header\"></div>");
                %>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a href="index.jsp">User Home<!--[if IE 7]><!--></a><!--<![endif]-->
                        </li>
                        <li><a href="newsDashboard.jsp">Add News<!--[if IE 7]><!--></a><!--<![endif]-->
                            <% if (user != null) {
                            %>
                        </li>
                            <li><a class="current" href="<%=user.getLink()%>">Dashboard</a>
                            </li>
                            <%}%>
                    </ul>
                </div> 
                <div class="center_content">
                    <%@ include file="adminLeftBar.html" %>
                    <div class="right_content">            
                        <h2>Question Statistics</h2> 
                            <table id="rounded-corner">
                                <thead>
                                    <tr>
                                        <th scope="col" class="rounded2" align="center">Questions</th>
                                        <th scope="col" class="rounded2" align="center">A</th>
                                        <th scope="col" class="rounded2" align="center">B</th>
                                        <th scope="col" class="rounded2" align="center">C</th>
                                        <th scope="col" class="rounded2" align="center">D</th>
                                        <th scope="col" class="rounded2" align="center">E</th>
                                        <th scope="col" class="rounded2" align="center">Unanswered</th>
                                        <th scope="col" class="rounded2" align="center">Multiple</th>
                                        <th scope="col" class="rounded2" align="center">Correct</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        double[] stats;
                                        stats = Marks.getStatistcs(qNumber);
                                    %>
                                    <tr>
                                        <td><%="Q" + qNumber %></td>
                                        <td ><%=(int) stats[0]%></td>
                                        <td><%=(int) stats[1]%></td>
                                        <td><%=(int) stats[2]%></td>
                                        <td><%=(int) stats[3]%></td>
                                        <td><%=(int) stats[4]%></td>
                                        <td><%=(int) stats[5]%></td>
                                        <td><%=(int) stats[6]%></td>
                                        <td><%=(int) stats[7]%></td>
                                    </tr>
                                </tbody>
                            </table>
                                    <br></br>
                                <% if (qNumber < 30) {
                                %>
                                <font size="3"><a href=<%="questionStats.jsp?qNum=" + (qNumber + 1)%>>Next Question</a></font>
                                <%}%>
                            
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
                        <%
                                double[] s;
                                stats = Marks.getStatistcs(qNumber);
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
                <div id="statsG" style="height: 500px; width: 600px;"></div><br><br>
                        <table border="0" align="center">
                    <tr>
                        <td>
                            <div id="statscp1" style= "width: 300px;"></div><br><br>
                        </td>
                        <td>
                            <div id="statscp2" style= "width: 300px;"></div><br><br>
                        </td>
                    </tr>
                </table>
                        <% if (qNumber < 30) {
                        %>
                        <font size="3"><a href=<%="questionStats.jsp?qNum=" + (qNumber + 1)%>>Next Question</a></font>
                        <% }
                                    }%>
                    </div><!-- end of right content-->
                </div>   <!--end of center content -->        
                <div class="clear"></div>
            </div> <!--end of main content-->
            <div class="footer">
                <div class="left_footer">SLOMF ADMIN PANEL | Powered by Fiontar</div>
                <div class="right_footer"><a href="http://indeziner.com"><img src="css/images/fiontar.png"/></a></div>
            </div>
        </div>		
    </body>
</html>