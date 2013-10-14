<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="slmo.registration.User"%>
<%@page import="slmo.registration.ResultSheet"%>

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
        ResultSheet resultSheet = null;
        try {
            resultSheet = (ResultSheet) session.getAttribute("resultSheet");
            out.print("Getting it");
        } catch (Exception ex) {
            out.print("Fail!!!");
        }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ADMIN PANEL</title>
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
            function isNumberKey(evt) {
                var charCode = (evt.which) ? evt.which : event.keyCode
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;
                return true;
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
                            <li><a class="current" href="<%=user.getLink()%>">Dashboard</a>
                            </li>
                            <%}%>
                    </ul>
                </div> 
                <div class="center_content">
                    <div class="left_content">
                        <div class="sidebar_search">
                            <form name="searchForm" method="post" action="GetAnswerScript">
                                <input class="search_input" type="text" value="Index number"
                                       onBlur="if (this.value == '')
                                            this.value = 'Index number'"
                                       onFocus="if (this.value == 'Index number')
                                            this.value = ''" name="indexNum" onkeypress="return isNumberKey(event)"/>
                                <input type="image" class="search_submit" src="css/images/search.png"/>
                            </form>
                        </div>
                        <div class="sidebarmenu">            
                            <a class="menuitem submenuheader" href="">Add</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="">Student</a></li>
                                    <li><a href="addSchoolManual.jsp">School</a></li>
                                </ul>
                            </div>
                            <a class="menuitem submenuheader" href="">Centers </a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="centreInformation.jsp">Center Information</a></li>
                                    <li><a href="centerStatistics.jsp">Center Statistics</a></li>
                                    <li><a href="CommandServlet?id=assignCentres">Assign Centers</a></li>
                                </ul>
                            </div>
                            <a class="menuitem submenuheader" href="">Generate Reports</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="DownloadServlet?name=AttendanceSheets">Attendance Sheets</a></li>
                                    <li><a href="DownloadServlet?name=Classrooms">Classroom Labels</a></li>
                                    <li><a href="DownloadServlet?name=ResultSheet">Result Sheets of Schools</a></li>
                                    <li><a href="DownloadServlet?name=Database">Database</a></li>

                                </ul>
                            </div>
                            <a class="menuitem" href="CommandServlet?id=sendAdmission" onclick="return message();">Send Admission Cards</a>
                            <a class="menuitem submenuheader" href="">Answer Sheets</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="upload.jsp?file=Excel File">Upload Answer Sheets</a></li>
                                    <li><a href="CommandServlet?id=calculateMarks">Calculate Marks</a></li>
                                    <li><a href="resultsStatistics.jsp">Answer Statistics</a></li>
                                    <li><a href="answerSheet.jsp" onclick="return message();">Review Answer Scripts</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <div>
                                    <h5>Upload photos</h5>
                                </div>

                                <a href="upload.jsp?file=Photographs">
                                    <img src="css/images/photo.png" border="0" class="sidebar_icon_right" />
                                </a>
                                <p>
                                    Upload photographs of SLOMF special sessions.
                                </p>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>  

                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h3>To do List</h3>
                                <img src="css/images/info.png" alt="" title="" class="sidebar_icon_right" />
                                <ul>
                                    <li>Check registered schools and students</li>
                                    <li>Insert school details manually</li>
                                    <li>Assign examination centres to the applicants</li>
                                    <li>Send admission cards</li>
                                </ul>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>

                    </div>

                    <div class="right_content">
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
                                } else
                                    out.print("No Match Found!!");
                            %>

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

    <%
        }
    %>
</html>