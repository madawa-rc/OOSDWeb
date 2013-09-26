<%-- 
    Document   : signup
    Created on : Sep 21, 2013, 6:51:50 AM
    Author     : Kasun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SLOMF</title>
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
                            <p>by ID & Saami</p>
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
                            <div style= "width:850px; margin:auto;">
                                <div class="box-2">
                                    <p><strong>
                                            <font size="+2">Registration Form</font>
                                            <br><br>
                                        </strong></p>
                                        <form action="StudentRegistrationServlet" name="register" method="post" id="Signup">
                                        <div>
                                            <div  class="wrapper">
                                                <span>First name:</span>
                                                <div class="bg"><input type="text" class="input" name="name" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Email:</span>
                                                <div class="bg"><input type="text" class="input" name="email" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Date of Birth:</span>
                                                <div class="bg">
                                                    <select name="date" required="true">
                                                        <option value="" style="display:none;">Date</option>
                                                        <%
                                                            for (int i = 1; i < 32; ++i)
                                                                out.print("<option value=\""+i+"\">" + i + "</option>");
                                                        %>
                                                    </select>
                                                    <select name="month" required="true">
                                                        <option value="" style="display:none;">Month</option>
                                                        <%
                                                            for (int i = 1; i < 13; ++i)
                                                                out.print("<option value=\""+i+"\">" + i + "</option>");
                                                        %>
                                                    </select>
                                                    <select name="year" required="true">
                                                        <option value="" style="display:none;">Year</option>
                                                        <%
                                                            for (int i = 1994; i < 2011; ++i)
                                                                out.print("<option value=\""+i+"\">" + i + "</option>");
                                                        %>
                                                    </select>
                                                </div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>Gender:</span>
                                                <div class="bg">
                                                    <input type="radio" name="gender" value="male" required="true">
                                                    <label for="male">male</label>
                                                    <input type="radio" name="gender" value="female" required="true">
                                                    <label for="female">female</label>
                                                </div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>School:</span>
                                                <div class="bg"><input type="text" class="input" name="school" required="true"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Home address:</span>
                                                <div class="bg"><input type="text" class="input" name="home_addr" required="true"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>School address:</span>
                                                <div class="bg"><input type="text" class="input" name="school_addr" required="true"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Telephone:</span>
                                                <div class="bg"><input type="text" class="input" name="phone" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Medium:</span>
                                                <div class="bg">
                                                    <input type="radio" name="medium" value="sinhala" required="true">
                                                    <label for="sinhala">Sinhala</label>
                                                    <input type="radio" name="medium" value="english" required="true">
                                                    <label for="english">English</label>
                                                    <input type="radio" name="medium" value="tamil" required="true">
                                                    <label for="english">Tamil</label>
                                                </div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>Exam center:</span>
                                                <div class="bg">
                                                    <select name="preferred_centre" id="preferred_centre" required="true">
                                                        <option value="" style="display:none;">Select centre...</option>
                                                        <option value="Colombo">Colombo</option>
                                                        <option value="Galle">Galle</option>
                                                        <option value="Matara">Matara</option>
                                                        <option value="Kurunegala">Kurunegala</option>
                                                        <option value="Trincomalee">Trincomalee</option>
                                                        <option value="Jaffna">Jaffna</option>
                                                        <option value="Anuradhapura">Anuradhapura</option>
                                                        <option value="Kandy">Kandy</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <br><br>
                                            <input type="submit" value="submit" class="button" align="right">
                                            <input type="reset" value="Clear" class="button"/><br><br>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>	            
                    </div>
                </div>
            </div>
            <p class="para" align="right"><font size="5px">Follow Us:</font></p>
            <ul class="social-list">
                <li><a href="#"><img src="images/social-link-1.jpg" alt=""></a></li>
                <li><a href="https://www.facebook.com/photo.php?fbid=531306523587668&set=pb.285656058152717.-2207520000.1380090385.&type=3&theater"><img src="images/social-link-2.jpg" alt=""></a></li>
                <li><a href="#"><img src="images/social-link-3.jpg" alt=""></a></li>
                <li><a href="#"><img src="images/social-link-4.jpg" alt=""></a></li>
            </ul>
        </div>
        <div>
            <div class="5grid-layout" id="copyright">
                <div class="row">
                    <div class="12u">
                        <p>Sri Lanka Mathematics Olympiad Foundation | 2013.09.21 | Contact: +94 11 212 345 6</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
