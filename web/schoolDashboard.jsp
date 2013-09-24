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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SLOMF</title>
        <link rel="shortcut icon" href="images/logo.png">        
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <%
        School s = (School) request.getAttribute("schoolObject");
        out.print(s.getName());
        out.println("got the school from the database successfully to the jsp");
        ArrayList<Student> studentList = null;
        studentList = s.getStudentList();
        out.print(studentList.size());

    %>
    <body>
        <h1>School Dashboard</h1>


        <SCRIPT language="javascript">
        
            function addRow(tableID) {
                var n = document.getElementById("num").value;
                n = parseInt(n);
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

                var cell1 = row.insertCell(0);
                var element1 = document.createElement("input");
                element1.type = "hidden";
                element1.value = n + 1;
                cell1.appendChild(element1);

                var cell2 = row.insertCell(1);
                var element2 = document.createElement("input");
                element2.type = "text";
                element2.id = "student" + (n + 1);
                element2.name = "student" + (n + 1);
                element2.required = "true";
                element2.value = "student" + (n + 1);
                cell2.appendChild(element2);

                var cell3 = row.insertCell(2);
                var element3 = document.createElement("input");
                element3.type = "button"
                element3.value = "Delete";
                element3.onclick = function() {
                    deleteRow(tableID, n + 1);
                };
                cell3.appendChild(element3);

                var cell4 = row.insertCell(3);
                var element4 = document.createElement("input");
                element4.type = "button"
                element4.value = "Add";
                element4.onclick = function() {
                    addRow(tableID);
                };
                hideAll(tableID);
                cell4.appendChild(element4);
                document.getElementById("num").value = n + 1;


            }

            function hideAll(tableID) {
                try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    for (var i = 0; i < rowCount - 1; i++) {
                        var row = table.rows[i].cells[1].childNodes[0].value;
                        if (null != row) {
                            table.rows[i].cells[3].childNodes[0].style.display = "none";
                        }
                    }

                } catch (e) {
                    alert(e);
                }
            }

            function deleteRow(tableID, row) {
                var x = window.confirm("Are you sure you want to delete this row?")
                if (x)
                {
                    var Num = parseInt(row);
                    try {
                        var table = document.getElementById(tableID);
                        var rowCount = table.rows.length;
                        for (var i = 0; i < rowCount; i++) {
                            var row = table.rows[i].cells[0].childNodes[0].value;
                            if (null != row && row == Num) {
                                table.rows[i].cells[1].childNodes[0].value = "deleted";
                                table.deleteRow(i);
                                rowCount = table.rows.length;
                                if (rowCount > 0)
                                    table.rows[rowCount - 1].cells[3].childNodes[0].style.display = "";
                                break;
                            }
                        }

                    } catch (e) {
                        alert(e);
                    }
                }
            }
        </SCRIPT> 
    </HEAD> 

<BODY>

    <form name="myform" action="myServlet" method="post">

        <INPUT type="text" value=<%=studentList.size()%> id="num" name ="num" required="true"/>
        <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" /> 
        <br>    


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
                        <% out.print(studentList.get(0).getName());%>
                    </td>
                    <td>
                        <select name="date" required="true">
                            <option value="<%= studentList.get(i).getDate()%>"><% studentList.get(i).getDate();%></option>
                            <%
                                for (int j = 1; j < 32; ++j) {
                                    out.print("<option value=\"" + j + "\">" + j + "</option>");
                                }
                            %>
                        </select>
                        <select name="month" required="true">
                            <option value="<%=studentList.get(i).getMonth()%>"><% studentList.get(i).getDate();%></option>
                            <%
                                for (int j = 1; j < 13; ++j) {
                                    out.print("<option value=\"" + j + "\">" + j + "</option>");
                                }
                            %>
                        </select>
                        <select name="date" required="true">
                            <option value="<%=studentList.get(i).getYear()%>"><% studentList.get(i).getDate();%></option>
                            <%
                                for (int j = 1994; j < 2011; ++j) {
                                    out.print("<option value=\"" + j + "\">" + j + "</option>");
                                }
                            %>
                        </select>
                    </td>
                    <td>
                        <% out.print(studentList.get(0).getMedium());%>
                    </td>
                </tr>
                <% }%>
            </table>
        </div>


        <br><br>

        <input type="submit" value="Go!"/>

    </form>
</body>
</html>
