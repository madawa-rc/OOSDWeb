<%-- 
    Document   : addSchoolManual
    Created on : 04-Oct-2013, 21:45:03
    Author     : Madawa
--%>


<%@page import="slmo.registration.User"%>
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
    <%
        User user = (User) session.getAttribute("user");
        if(user==null||!user.getName().equals("Admin"))
        {
            request.getSession().removeAttribute("user");
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an admin!");
        }
        else{
    %>
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


              <script language="javascript">
        
                function addRow(tableID) {
                    var n = document.getElementById("num").value;
                    n = parseInt(n);
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);

                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                
                    var element1 = document.createElement("input");
                    element1.type = "hidden";
                    element1.value = n + 1;
                
  
                    var element2 = document.createElement("input");
                    element2.type = "text";
                    element2.id = "student" + (n + 1);
                    element2.name = "student" + (n + 1);
                    element2.required = "true";
                    element2.value = "";
                    cell1.appendChild(element2);
                    cell1.appendChild(element1);
                
                    var element5 = document.createElement("select");
                    element5.id = "date" + (n + 1);
                    element5.name = "date" + (n + 1);
                    element5.required = "true";
                    nul5 = document.createElement("option"); nul5.value="";nul5.text="Select";nul5.style.display="none";
                    element5.appendChild(nul5);
                
                    for(var i=1;i<32;i++){
                        opt = document.createElement("option");
                        opt.value=i;
                        opt.text=i;
                        element5.appendChild(opt);
                    }
                    cell2.appendChild(element5);
                
                    var element6 = document.createElement("select");
                    element6.id = "month" + (n + 1);
                    element6.name = "month" + (n + 1);
                    element6.required = "true";
                    nul6 = document.createElement("option"); nul6.value="";nul6.text="Select";nul6.style.display="none";
                    element6.appendChild(nul6);
                
                    for(var i=1;i<13;i++){
                        opt = document.createElement("option");
                        opt.value=i;
                        opt.text=i;
                        element6.appendChild(opt);
                    }
                    cell2.appendChild(element6);
                
                    var element7 = document.createElement("select");
                    element7.id = "year" + (n + 1);
                    element7.name = "year" + (n + 1);
                    element7.required = "true";
                    nul7 = document.createElement("option"); nul7.value="";nul7.text="Select";nul7.style.display="none";
                    element7.appendChild(nul7);
                
                    for(var i=1994;i<2011;i++){
                        opt = document.createElement("option");
                        opt.value=i;
                        opt.text=i;
                        element7.appendChild(opt);
                    }
                    cell2.appendChild(element7);
                
                    var element8 = document.createElement("select");
                    element8.id = "medium" + (n + 1);
                    element8.name = "medium" + (n + 1);
                    element8.required = "true";
                    nul8 = document.createElement("option"); nul8.value="";nul8.text="Select";nul8.style.display="none";
                    element8.appendChild(nul8);
                
                    for(var i=0;i<3;i++){
                        opt = document.createElement("option");
                        if(i==0)
                            str="SINHALA";
                        else if(i==1)
                            str="ENGLISH";
                        else
                            str="TAMIL";
                        opt.value=str;
                        opt.text=str;
                        element8.appendChild(opt);
                    }
                    cell3.appendChild(element8);
                
                    var element3 = document.createElement("input");
                    element3.type = "button";
                    element3.value = "Delete";
                    element3.onclick = function() {
                        deleteRow(tableID, n + 1);
                    };
                
                    var element4 = document.createElement("input");
                    element4.type = "button";
                    element4.value = "Add";
                    element4.onclick = function() {
                        addRow(tableID);
                    };
                    hideAll(tableID);
                    cell3.appendChild(element3);
                    cell3.appendChild(element4);
                
                    document.getElementById("num").value = n + 1;


                }

                function hideAll(tableID) {
                    try {
                        var table = document.getElementById(tableID);
                        var rowCount = table.rows.length;
                        for (var i = 1; i < rowCount - 1; i++) {
                            var row = table.rows[i].cells[2].childNodes[2].value;
                            if (null != row) {
                                table.rows[i].cells[2].childNodes[2].style.display = "none";
                            }
                        }

                    } catch (e) {
                    
                    }
                }

                function deleteRow(tableID, rw) {
                    var x = window.confirm("Are you sure you want to delete this row?")
                    if (x)
                    {
                        var Num = parseInt(rw);
                        try {
                            var table = document.getElementById(tableID);
                            var rowCount = table.rows.length;
                            for (var i = 1; i <rowCount; i++) {
                                var row = table.rows[i].cells[0].childNodes[1].value;
                                if (null != row && row == Num) {
                                    document.getElementById("medium"+Num).value= "deleted";
                                    table.deleteRow(i);
                                    rowCount = table.rows.length;
                                    //  if (rowCount > 2)
                                    //      table.rows[rowCount - 1].cells[2].childNodes[2].style.display = "";
                                    break;
                                }
                            }

                        } catch (e) {
                            alert(e);
                        }
                    }
                }
            </SCRIPT>  

            <form name="add_student" action="AddSchoolManualServlet" method="post">
                 <INPUT type="hidden" value="0" id="num" name ="num" required="true"/>
                <div class="8u">
                    <span>School</span> Name <input class="input" type="text" name="name" required="true"><br>
                    <span>Teacher In Charge</span><input type="text" name="contactname" required="true"><br>
                    <span>E mail</span> <input type="email" name="email" required="true"><br>
                    <span>School Address</span><input type="text" name="school_addr" required="true"><br>
                    <span>Telephone Number</span><input type="text" name="phone" required="true"><br>
                    <span>Preferred Centre</span>
                    <select name="preferred_centre" name="preferred_centre" required="true">
                        <option value="" style="display:none;">Select centre...</option>
                        <option value="Colombo">Colombo</option>
                        <option value="Galle">Galle</option>
                        <option value="Jaffna">Jaffna</option>
                        <option value="Kandy">Kandy</option>
                        <option value="Kurunegala">Kurunegala</option>
                        <option value="Matara">Matara</option>
                        <option value="Trincomalee">Trincomalee</option>
                    </select>
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
    <%
        }
    %>
</html>