<%-- 
    Document   : login
    Created on : Sep 22, 2013, 5:16:45 PM
    Author     : Kasun
--%>
<%@page import="slmo.registration.School"%><font color="#ff0000">
<%
    session.setMaxInactiveInterval(10);
    School school = (School) session.getAttribute("sch");
    boolean loggedIn = false;
    if (school != null) {
        loggedIn = true;
    }
%>
</font>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
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
    </head><body>
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
                            <div style= "width:350px; margin: 0 auto">
                                <div class="box-2">
                                    <p class="para">
                                        <strong>
                                            <%
                                                if (loggedIn) {
                                                    out.print("You are logged in!");
                                                } else {
                                                    out.print("Enter your Login details");
                                            %><br>
                                            <font color="#ff0000" size="3px">
                                            <%
                                                String msg = request.getParameter("id");
                                                if (msg != null) {
                                                    out.print(msg);
                                                }
                                            %>
                                            </font>  
                                            <br><br>
                                        </strong>
                                    </p>
                                    <p class="p1">
                                    <form name="login" method="post" action="SchoolLoginServlet">
                                        <input type="text" value="Enter your email" name="email" id="email"
                                               onBlur="if(this.value=='') this.value='Enter your email'"
                                               onFocus="if(this.value =='Enter your email' ) this.value=''" ><br><br>
                                        <input type="password" value="******" name="password" id="password"
                                               onBlur="if(this.value=='') this.value='******'"
                                               onFocus="if(this.value =='******' ) this.value=''" ><br><br>
                                        <input type="submit" value="Login" class="button"/>
                                        <input type="reset" value="Clear" class="button"/>
                                    </form>
                                    </p><br>
                                    <p class="para" align="right">New user?</p>
                                    <p class="para" align="right"><a href="school.jsp">Sign up</a> here.</p>
                                    <%}
                                    %>
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