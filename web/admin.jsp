<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : schoolDashboard
    Created on : 23-Sep-2013, 21:36:04
    Author     : Madawa
--%>
<%@page import="slmo.registration.School"%>
<%@page import="java.util.ArrayList"%>
<%@page import="slmo.registration.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !user.getName().equals("Admin")) {
        request.getSession().removeAttribute("user");
        response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Administrator!");
    } else {
        ArrayList<School> list;
        list = (ArrayList<School>) session.getAttribute("schoolList");
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
                <%                    
                    }else
                        out.print("<div class=\"right_header\"></div>");
                %>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a href="index.jsp">User Home<!--[if IE 7]><!--></a><!--<![endif]-->
                        </li>
                        <li><a href="#">Add News<!--[if IE 7]><!--></a><!--<![endif]-->
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
                            <form name="searchForm" action="AdminServlet" method="post">
                                <input type="text" name="search" class="search_input" value="Search school" onclick="this.value=''" />
                                <input type="image" class="search_submit" src="css/images/search.png" />
                            </form>
                            <form name="getSchool" method="post" action="AdminServlet" >
                                <input type="hidden" name="schoolEmail" value="" id="schoolEmail"/>
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
                            <a class="menuitem submenuheader" href="">Centres </a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="centreInformation.jsp">Centre Information</a></li>
                                    <li><a href="centerStatistics.jsp">Centre Statistics</a></li>
                                    <li><a href="CommandServlet?id=assignCentres">Assign Centres</a></li>
                                </ul>
                            </div>
                            <a class="menuitem submenuheader" href="">Generate Reports</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="DownloadServlet?name=AttendanceSheets">Attendance Sheets</a></li>
                                    <li><a href="DownloadServlet?name=Database">Database</a></li>
                                    <li><a href="DownloadServlet?name=Classroom">Classroom Banner</a></li>
                                </ul>
                            </div>
                            <a class="menuitem" href="CommandServlet?id=sendAdmission" onclick="return message();">Send Admission Cards</a>
                            <a class="menuitem submenuheader" href="">Answer Sheets</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="upload.jsp">Upload Answer Sheets</a></li>
                                    <li><a href="resultsStatistics.jsp">Answer Statistics</a></li>
                                    <li><a href="answerSheet.jsp" onclick="return message();">Review Answer Scripts</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h5>Upload photos</h5>
                                <img src="css/images/photo.png" alt="" title="" class="sidebar_icon_right" />
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
                                    <li>Finalize coding this shit</li>
                                    <li>Upload the source code</li>
                                    <li>Explain about this software to CG <strong>(CRITICAL)</strong></li>
                                </ul>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>
                    </div>

                    <div class="right_content">
                        <%
                            
                            if (list == null); else if (list.size() == 0) {
                                out.print("<h3>Search Results:</h3><br><br><br>");
                                out.print("<ul type=\"none\"><li>&nbsp;&nbsp;&nbsp;No match found!</li></ul>");
                            } else {
                                out.print("<h3>Search Results:</h3><br><br><br>");
                        %>
                        <%
                            for (int i = 0; i < list.size(); ++i) {
                        %>
                        <ul type="square"><li>
                                &nbsp;&nbsp;&nbsp;<a href="<%="AdminServlet?schoolEmail=" + list.get(i).getEmail()%>" target="new"><%out.print(list.get(i).getName());%></a>
                            </li>
                        </ul>
                        <%}
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
                            <% }%>
</html>