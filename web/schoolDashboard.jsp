<%-- 
    Document   : schoolDashboard
    Created on : 23-Sep-2013, 21:36:04
    Author     : Madawa
--%>

<%@page import="slmo.registration.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="slmo.registration.School"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
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
        School s = (School) request.getAttribute("schoolObject");
        ArrayList<Student> studentList = null;
        studentList = s.getStudentList();
    %><body><div id="header-wrapper">
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
                <p align="center"><font face="Arial" size="20px"><u>School Dashboard</u></font></p>
            </div>


            <SCRIPT language="javascript">
        
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
                        for (var i = document.getElementById("num2").value; i < rowCount - 1; i++) {
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

        <form name="myform" action="SchoolModifyServlet" method="post">

            <INPUT type="hidden" value=<%=studentList.size()%> id="num" name ="num" required="true"/>
            <INPUT type="hidden" value=<%=studentList.size()%> id="num2" name ="num2" required="true"/>
            <INPUT type="hidden" value=<%=s.getEmail()%> id="email" name ="email" required="true"/>
            
            <br><br>  
            <div class="StudentData" >
                <table id="dataTable" width="350px" border="0">
                    <tr>
                        <td>
                            Name
                        </td>
                        <td >
                            Date of birth
                        </td>
                        <td>
                            Medium
                        </td>
                    </tr>
                    <%
                        if (studentList != null)
                            for (int i = 0; i < studentList.size(); ++i) {
                    %>

                    <tr>
                        <td >
                            <INPUT type="hidden" value=<%=String.valueOf(i + 1)%> />              
                            <INPUT type="text" value="<%=studentList.get(i).getName()%>" id=<%="student" + String.valueOf(i + 1)%> name=<%="student" + String.valueOf(i + 1)%> required="true"/>                
                        </td>
                        <td>
                            <select name=<%="date" + String.valueOf(i + 1)%> required="true">
                                <option value="<%= studentList.get(i).getDate()%>" style="display:none"><%=studentList.get(i).getDate()%></option>
                                <%
                                    for (int j = 1; j < 32; ++j) {
                                        out.print("<option value=\"" + j + "\">" + j + "</option>");
                                    }
                                %>
                            </select>
                            <select name=<%="month" + String.valueOf(i + 1)%> required="true">
                                <option value="<%=studentList.get(i).getMonth()%>" style="display:none"><%=studentList.get(i).getMonth()%></option>
                                <%
                                    for (int j = 1; j < 13; ++j) {
                                        out.print("<option value=\"" + j + "\">" + j + "</option>");
                                    }
                                %>
                            </select>
                            <select name=<%="year" + String.valueOf(i + 1)%> required="true">
                                <option value="<%=studentList.get(i).getYear()%>" style="display:none"><%=studentList.get(i).getYear()%></option>
                                <%
                                    for (int j = 1994; j < 2011; ++j) {
                                        out.print("<option value=\"" + j + "\">" + j + "</option>");
                                    }
                                %>
                            </select>
                        </td>
                        <td>
                            <select name =<%="medium" + String.valueOf(i + 1)%>  id = <%="medium" + String.valueOf(i + 1)%>  required="true">
                                    <option value="<%=studentList.get(i).getMedium()%>" style="display:none"><%=studentList.get(i).getMedium()%></option>
                                <option value="ENGLISH">ENGLISH</option>;
                                <option value="SINHALA">SINHALA</option>;
                                <option value="TAMIL">TAMIL</option>;        
                            </select>

                            <INPUT type="hidden" value=<%=studentList.get(i).getId()%> name=<%="studentId" + String.valueOf(i + 1)%> />
                            <INPUT type="button" value="Delete" onclick="deleteRow('dataTable','<%=String.valueOf(i + 1)%>');" />
                        </td>
                    </tr>
                    <% }%>
                </table>

            </div><br><br>
            <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" class="button"/> 
            <input type="submit" value="Go!" class="button"/>
        </form>

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
                    <p>Sri Lanka Mathematics Olympiad Foundation | 2013.09.21 | Contact: +94 71 546 517 8</p>
                </div>
            </div>
        </div>
    </div>



</body>
</html>
