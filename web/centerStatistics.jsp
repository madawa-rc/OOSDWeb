<%@page import="slomf.admin.center.CenterAllocation"%>
<%@page import="slomf.registration.User"%>
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
        int[][] preferredCenters = CenterAllocation.getPreferredCenterStats();
        int[][] assignedCenters = CenterAllocation.getAssignedCenterStats();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Centre Statistics</title>
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
                        </li>
                            <li><a class="current" href="admin.jsp">Dashboard</a>
                            </li>
                    </ul>
                </div> 
                <div class="center_content">
                    <%@ include file="adminLeftBar.html" %>
                    <div class="right_content">
                        <h2>Examination Centre Statistics</h2><br>
                        <h4>Preferred Centre</h4><br>
                        <table id="rounded-corner">
                            <thead>
                                <tr>
                                    <th scope="col" class="rounded2" align="center">Preferred Centre</th>
                                    <th scope="col" class="rounded2" align="center">Sinhala</th>
                                    <th scope="col" class="rounded2" align="center">English</th>
                                    <th scope="col" class="rounded2" align="center">Tamil</th>
                                    <th scope="col" class="rounded2" align="center">Total</th>
                                </tr>
                            </thead>
                            <tbody>
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
                                        <%                                            } else {
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
                                    </td>
                                </tr>    
                            </tbody>
                            <%      }//end of for
                                    }//end of if
%>
                        </table>
                        <br></br>
                        <h4>Assigned Centre</h4><br>
                        <table id="rounded-corner">
                            <thead>
                                <tr>
                                    <th scope="col" class="rounded2" align="center">Assigned Centre</th>
                                    <th scope="col" class="rounded2" align="center">Sinhala</th>
                                    <th scope="col" class="rounded2" align="center">English</th>
                                    <th scope="col" class="rounded2" align="center">Tamil</th>
                                    <th scope="col" class="rounded2" align="center">Total</th>
                                </tr>
                            </thead>
                            <tbody>
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
                                        <%                                            } else {
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
                            </tbody>
                            <%      }//end of for
                                    }//end of if
                            %>
                        </table>
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