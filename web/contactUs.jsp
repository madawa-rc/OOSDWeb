<%-- 
    Document   : contactUs
    Created on : Sep 25, 2013, 11:22:06 AM
    Author     : Fiontar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact us</title>
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
                                            <font size="+2">Contact Form</font>
                                            <br><br>
                                        </strong></p>





                                    <form action="ContactFormServlet" name="contactUs" id="ContactForm" method="post" >
                                        <div>
                                            <div  class="wrapper">
                                                <span>Name:</span>
                                                <div class="bg"><input type="text" class="input" name="name" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Address:</span>
                                                <div class="bg"><input type="text" class="input" name="address" required="true"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Email:</span>
                                                <div class="bg"><input type="text" class="input" name="email" required="true"></div>								
                                            </div><br>
                                            <div  class="textarea_box">
                                                <span>Message:</span><br><br>
                                                <div class="bg"><textarea name="message" cols="1" rows="1" required="true"></textarea></div>	
                                            </div><br><br><br><br><br><br><br><br><br>
                                            <input type="submit" value="Send" class="button" align="right">
                                            <input type="reset" value="Clear" class="button"/><br><br>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div id="wrapper">
                            <div id="marketing">
                                <div class="5grid-layout">
                                    <div class="row divider">
                                        <div class="3u">
                                            <section>
                                                <h2 class="contact">Isuru </h2>
                                                <p class="address"><span class="color2"></span>
                                                    158, 2nd Corridor, Whitehouse<br>
                                                    <span>Telephone:</span>+94 71 546 517 8<br>
                                                    <span>Fax:</span>+94 11 279 279 9<br>
                                                    <span>Email:</span><a href="mailto:">isuruf@gmail.com</a>
                                                </p>
                                            </section>
                                        </div>


                                        <div class="3u">
                                            <section>
                                                <h2 class="contact">Saami</h2>
                                                <p class="address"><span class="color2"></span>
                                                    448, Mora Road, Katubedda<br>
                                                    <span>Telephone:</span>+94 77 345 567 8<br>
                                                    <span>Fax:</span>+94 77 345 567 8<br>
                                                    <span>Email:</span><a href="mailto:">shehan@moviehut.lk</a>
                                                </p>
                                            </section>
                                        </div>
                                    </div>
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
                        <p>Sri Lanka Mathematics Olympiad | 2013.09.25 | Contact: +94 71 546 517 8</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
