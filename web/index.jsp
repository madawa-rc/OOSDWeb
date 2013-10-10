<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : index
    Created on : Sep 19, 2013, 3:53:21 PM
    Author     : New
--%>

<%@page import="slmo.registration.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />        
        <title>Home- SLOMF</title>
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
                        <li><a class="current" href="./">Home</a></li>
                        <li><a href="#">News</a></li>
                        <li><a href="#">Register</a>
                            <ul>
                                <li><a href="register.jsp" title="">As a Private Applicant</a></li>
                                <li><a href="school.jsp" title="">As a School</a></li>
                            </ul>
                        </li>
                        <li><a href="login.jsp">Login</a></li>
                        <% if (user != null) {
                        %>
                        <li><a href="<%=user.getLink()%>">Dashboard</a>
                        </li>
                        <%}%>
                        <li><a href="contactUs.jsp">Contact us</a></li>
                    </ul>
                </div>
                <div class="center_content">

                    <div class="left_content">
                        <div>
                            <p>
                                <img src ="images/logo2.png"alt="" align="left">
                                    <font color="white">You got it!</font>                          
                            </p>
                        </div> 
                        <div class="sidebarmenu">            
                            <a class="menuitem submenuheader" href="">IMO</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="">IMO 2013</a></li>
                                    <li><a href="">IMO 2012</a></li>
                                    <li><a href="">IMO 2011</a></li>
                                </ul>
                            </div>
                            <a class="menuitem submenuheader" href="">SLMO</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="">SLMO 2013</a></li>
                                    <li><a href="">SLMO 2012</a></li>
                                    <li><a href="">SLMO 2011</a></li>
                                </ul>
                            </div>
                            <a class="menuitem" href="" >Our Vision</a>
                            <a class="menuitem" href="">Our Mission</a>
                        </div>
                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h3>Latest News</h3>

                                <p>
                                    News 1 <br>
                                        News 2 <br>
                                            </p>                
                                            </div>
                                            <div class="sidebar_box_bottom"></div>
                                            </div>

                                            <div class="sidebar_box">
                                                <div class="sidebar_box_top"></div>
                                                <div class="sidebar_box_content">
                                                    <h3>User help desk</h3>
                                                    <img src="css/images/info.png" alt="" title="" class="sidebar_icon_right" />
                                                    <p>
                                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                                    </p>                
                                                </div>
                                                <div class="sidebar_box_bottom"></div>
                                            </div>



                                            <div class="sidebar_box">
                                                <div class="sidebar_box_top"></div>
                                                <div class="sidebar_box_content">
                                                    <h3>Follow us</h3>
                                                    <p>
                                                        <a href="#"><img src="images/social-link-1.jpg" style="margin:0 5px"alt="" align="left"/></a>
                                                        <a href="https://www.facebook.com/photo.php?fbid=531306523587668&set=pb.285656058152717.-2207520000.1380090385.&type=3&theater" target="new">
                                                            <img src="images/social-link-2.jpg" style="margin:0 5px"alt="" align="left"/></a>
                                                        <a href="#"><img src="images/social-link-3.jpg"style="margin:0 5px" alt="" align="left"/></a>
                                                        <a href="#"><img src="images/social-link-4.jpg"style="margin:0 5px" alt="" align="left"/></a>
                                                        <br>
                                                    </p>
                                                </div>
                                                <div class="sidebar_box_bottom"></div>
                                            </div>
                                            </div> <!-- end of left content--> 

                                            <div class="right_content">            

                                                <h1>Welcome to Sri Lanka Olympiad Mathematics Foundation </h1> 
                                                <div>
                                                    <img src="images/front.jpg" alt="" align="left"/>
                                                </div>
                                            </div><!-- end of right content-->
                                            </div>   <!--end of center content -->

                                            <div class="clear"></div>





                                            </div> <!--end of main content-->


                                            <div class="footer">

                                                <div class="left_footer">SLOMF ADMIN PANEL | Powered by Fiontar</div>
                                                <div class="right_footer"><a href="http://indeziner.com"><img src="css/images/fiontar.png" alt="" title="" border="0" /></a></div>
                                            </div>

                                            </div>		
                                            </body>
                                            </html>