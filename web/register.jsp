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
                                    <li><a href="#">Register</a></li>
                                    <li><a href="#">Login</a></li>
                                    <li><a href="#">Contact us</a></li>
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
                                        <form action="StudentServlet" name="register" method="post" id="ContactForm">
                                        <div>
                                            <div  class="wrapper">
                                                <span>First name:</span>
                                                <div class="bg"><input type="text" class="input" name="name"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Email:</span>
                                                <div class="bg"><input type="text" class="input" name="email"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Password:</span>
                                                <div class="bg"><input type="password" class="input" name="pass"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Date of Birth:</span>
                                                <div class="bg"><input type="date" name="dob" name="dob"></div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>Gender:</span>
                                                <div class="bg">
                                                    <input type="radio" name="gender" value="male">
                                                    <label for="male">male</label>
                                                    <input type="radio" name="gender" value="female">
                                                    <label for="female">female</label>
                                                </div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>School:</span>
                                                <div class="bg"><input type="text" class="input" name="school"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Home address:</span>
                                                <div class="bg"><input type="text" class="input" name="homeaddr"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>School address:</span>
                                                <div class="bg"><input type="text" class="input" name="schooladdr"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Telephone:</span>
                                                <div class="bg"><input type="text" class="input" name="phone"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Medium:</span>
                                                <div class="bg">
                                                    <input type="radio" name="medium" value="sinhala">
                                                    <label for="sinhala">Sinhala</label>
                                                    <input type="radio" name="medium" value="english">
                                                    <label for="english">English</label>
                                                </div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>Type:</span>
                                                <div class="bg">
                                                    <input type="radio" name="type" value="private">
                                                    <label for="private">Private applicant</label>
                                                    <input type="radio" name="medium" value="school">
                                                    <label for="school">School applicant</label>
                                                </div>								
                                            </div>
                                            <div  class="wrapper">
                                                <span>Exam center:</span>
                                                <div class="bg">
                                                    <select name="country" id="country">
                                                        <option value="">Select center...</option>
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
                <li><a href="#"><img src="images/social-link-2.jpg" alt=""></a></li>
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
