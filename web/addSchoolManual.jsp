<%-- 
    Document   : addSchoolManual
    Created on : 04-Oct-2013, 21:45:03
    Author     : Madawa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="slmo.registration.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="slmo.registration.School"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add School</title>
        <link rel="shortcut icon" href="images/logo.png">
        <link rel="stylesheet" href="css/5grid/core.css" />
        <link rel="stylesheet" href="css/5grid/core-desktop.css" />
        <link rel="stylesheet" href="css/5grid/core-1200px.css" />
        <link rel="stylesheet" href="css/5grid/core-noscript.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/style-desktop.css" />
    </head>
    <body><div id="header-wrapper">
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
            <div class="1u" id="logo">
                <p align="center"><font face="Arial" size="20px"><u>Add school Manually</u></font></p>
            </div>


            <script type="text/javascript">
                function addRow(tableID){
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);
                    var cell = new Array();
                    var element = new Array();
                    
                    element[0] = document.createElement("input");
                    element[0].type = "text";
                    element[0].name = "name";
                    element[0].required = "true";
                    
                    element[1] = document.createElement("input");
                    element[1].type = "email";
                    element[1].name = "email";
                    element[1].required = "true";
                    
                    element[2] = document.createElement("input");//dob
                    element[2].type = "text";
                    
                    element[3] = document.createElement("select");
                    //element[3].type = "select";
                    opt = document.createElement("option"); opt.value="";opt.text="Select";opt.style.display="none";
                    element[3].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 0; opt.text = "Male";
                    element[3].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 1; opt.text = "Female";
                    element[3].appendChild(opt);
                    
                    element[4] = document.createElement("input");
                    element[4].type = "text";
                    element[5] = document.createElement("input");
                    element[5].type = "text";
                    element[6] = document.createElement("input");
                    element[6].type = "text";
                    element[7] = document.createElement("input");
                    element[7].type = "text";
                    
                    for(var i = 0; i < 8; i++){
                        cell[i] = row.insertCell(i);
                        cell[i].appendChild(element[i]);
                    }
                }
                
                /*function addRows(tableID){
                    var n = document.getElementsByName("num");
                    n = parseInt(n);
                    for(var i = 0; i < num; i++){
                        addRow(tableID);
                    }
                }*/
            </script>  

            <form name="school" action="" method="post">
                School Name<input type="text" name="school_name"><br>
                School Address<input type="text" name="school_address"><br>
                Number of Students<input type="text" name="num" placeholder="number of students">
                <input type="button" class="button" value="Add Students" onclick="addRows('dataTable')"><br><br>
                <div class="StudentData">
                    <table id="dataTable" border="0">
                        <tr>
                            <td>
                                Full Name
                            </td>
                            <td>
                                Email
                            </td>
                            <td>
                                Date of Birth
                            </td>
                            <td>
                                Gender
                            </td>
                            <td>
                                Home Address
                            </td>
                            <td>
                                Telephone
                            </td>
                            <td>
                                Medium
                            </td>
                            <td>
                                Exam centre
                            </td>
                        </tr>
                    </table>
                </div>
                <br><br>
                <input type="button" class="button" value="Add Student" onclick="addRow('dataTable')">
            </form>

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
