<%-- 
    Document   : school
    Created on : Sep 22, 2013, 4:51:47 PM
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
        <script type="text/javascript">
            function check(form){                
                if(form.password.value != form.cpass.value){
                    alert("Passswords do not match!");
                    form.cpass.focus();
                    return false;
                }
                return true;
            }
        </script>
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
                                        <form action="SchoolRegistrationServlet" name="register" method="post" id="Signup" onsubmit="return check(this)">
                                        <div>
                                            <div  class="wrapper">
                                                <span>School name:</span>
                                                <div class="bg"><input type="text" class="input" name="name" required="true"></div>								
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Teacher in charge:</span>
                                                <div class="bg"><input type="text" class="input" name="contactname" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Email:</span>
                                                <div class="bg"><input type="text" class="input" name="email" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Password:</span>
                                                <div class="bg"><input type="password" class="input" name="password" required="true"></div>
                                            </div><br>
                                            <div  class="wrapper">
                                                <span>Retype password:</span>
                                                <div class="bg"><input type="password" class="input" name="cpass" required="true"></div>
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
                                                <span>Preferred centre:</span>
                                                <div class="bg"><input type="text" class="input" name="preferred_centre" required="true"></div>								
                                            </div><br>
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
