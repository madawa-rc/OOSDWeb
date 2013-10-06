<%-- 
    Document   : addSchoolManual
    Created on : 04-Oct-2013, 21:45:03
    Author     : Madawa
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add School Manually</title>
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
                <p align="left"><font face="Helvitica" size="12px"><u>Add School Manually</u></font></p>
            </div>


            <script type="text/javascript">
                function addRow(tableID){
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    var element = new Array();
                    
                    //column 1 - name
                    element[0] = document.createElement("input");
                    element[0].type = "text";
                    element[0].id = "name";
                    element[0].name = "name";
                    element[0].required = "true";
                    cell1.appendChild(element[0]);
                    
                    //column 2 - DOB
                    var date = document.createElement("select");
                    date.id = "name";
                    date.name = "date";
                    date.required = "true";
                    opt = document.createElement("option"); opt.value =""; opt.text = "Select"; opt.style.display = "none";
                    date.appendChild(opt);
                    for(var i = 1; i < 32; i++){
                        opt = document.createElement("option");
                        opt.value = i;
                        opt.text = i;
                        date.appendChild(opt);
                    }
                    cell2.appendChild(date);
                    
                    var month = document.createElement("select");
                    month.id = "month";
                    month.name = "month";
                    month.required = "true";
                    opt = document.createElement("option"); opt.value =""; opt.text = "Select"; opt.style.display = "none";
                    month.appendChild(opt);
                    for(var i = 1; i < 13; i++){
                        opt = document.createElement("option");
                        opt.value = i;
                        switch(i){
                            case 1 : str = "January";
                                break;
                            case 2 : str = "February";
                                break;
                            case 3 : str = "March";
                                break;
                            case 4 : str = "April";
                                break;
                            case 5 : str = "May";
                                break;
                            case 6 : str = "June";
                                break;
                            case 7 : str = "July";
                                break;
                            case 8 : str = "August";
                                break;
                            case 9 : str = "September";
                                break;
                            case 10 : str = "October";
                                break;
                            case 11 : str = "November";
                                break;
                            case 12 : str = "December";
                                break;
                        }
                        opt.text = str;
                        month.appendChild(opt);
                    }
                    cell2.appendChild(month);
                    
                    var year = document.createElement("select");
                    year.id = "year";
                    year.name = "year";
                    year.required = "true";
                    opt = document.createElement("option"); opt.value =""; opt.text = "Select"; opt.style.display = "none";
                    year.appendChild(opt);
                    for(var i = 1994; i < 2011; i++){
                        opt = document.createElement("option");
                        opt.value = i;
                        opt.text = i;
                        year.appendChild(opt);
                    }
                    cell2.appendChild(year);
                    
                    //column 3 - gender
                    element[1] = document.createElement("select");
                    element[1].id = "gender";
                    element[1].name = "gender";
                    element[1].required = "true";
                    opt = document.createElement("option"); opt.value="";opt.text="Select";opt.style.display="none";
                    element[1].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 0; opt.text = "Male";
                    element[1].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 1; opt.text = "Female";
                    element[1].appendChild(opt);
                    cell3.appendChild(element[1]);
                    
                    //column 4 - medium
                    element[3] = document.createElement("select");
                    element[3].id = "medium";
                    element[3].name = "medium";
                    element[3].required = "true";
                    opt = document.createElement("option"); opt.value="";opt.text="Select";opt.style.display="none";
                    element[3].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 0; opt.text = "Sinhala";
                    element[3].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 1; opt.text = "English";
                    element[3].appendChild(opt);
                    opt = document.createElement("option"); opt.value = 1; opt.text = "Tamil";
                    element[3].appendChild(opt);
                    cell4.appendChild(element[3]);

                }
            </script>  

            <form name="add_student" action="" method="post">
                <div class="8u">
                    School Name <input type="text" required="true"><br>
                    E mail <input type="email" required="true"><br>
                    Contact Person<input type="text" required="true"><br>
                    Telephone Number<input type="text" required="true">
                </div>
                <br><br>  
                <div class="StudentData" >
                    <table id="dataTable" width="350px" border="0">
                        <tr>
                            <td>
                                Name
                            </td>
                            <td>
                                Date of birth
                            </td>
                            <td>
                                Gender
                            </td>
                            <td>
                                Medium
                            </td>
                        </tr>
                        
                    </table>

                </div><br><br>
                <input type="button" value="Add Student" onclick="addRow('dataTable');" class="button">
                <input type="submit" value="Submit" class="button">
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