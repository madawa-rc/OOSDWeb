<%-- 
    Document   : answerSheet
    Created on : Oct 7, 2013, 10:04:24 PM
    Author     : Fiontar
--%>

<%@page import="slmo.registration.User"%>
<%@page import="slmo.registration.ResultSheet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script language="javascript">
        function isNumberKey(evt){
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }
    </script>
    <%
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getName().equals("admin")) {
            request.getSession().removeAttribute("user");
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Admin!");
        } else {
            ResultSheet resultSheet = null;
            try {
                resultSheet = (ResultSheet) session.getAttribute("resultSheet");
            } catch (Exception ex) {
            }
    %>
    <body>
        <form name="searchForm" method="post" action="GetAnswerScript">
            <p class="para">&nbsp;Search:</font> &nbsp;&nbsp; 
                <input class="input" type="text" value="Index number"
                       onBlur="if (this.value == '')
                           this.value = 'Index number'"
                       onFocus="if (this.value == 'Index number')
                           this.value = ''" name="indexNum" onkeypress="return isNumberKey(event)">
                <input type="submit" value="Search" class="button">
            </p>
        </form>

        <%
            if (resultSheet != null) {
                String[] rs = resultSheet.getRecords();                
                String styleStart = "<font size=4><strong>";
                String styleEnd = "</font></strong>";
                out.print(styleStart+"Name: "+styleEnd+resultSheet.getName()+"<br>");
                out.print(styleStart+"School: "+styleEnd+resultSheet.getSchool()+"<br>");
                out.print(styleStart+"Index: "+styleEnd+resultSheet.getIndexNum()+"<br>");
                out.print(styleStart+"Examination centre: "+styleEnd+resultSheet.getAssignedCentre()+"<br><br>");
                for (int i = 0; i < 30; ++i) {
        %>
        <img src="<% out.print("images/score/" + rs[i] + ".jpg");%>">
        <%
                    if (i == 14) {
                        out.print("<br><br>");
                    }
                }
                out.print("<br><br><a href=\"GetAnswerScript?next=true\" align=\"center\">Next</a>");
            }
        %>
    </body>
    <%
        }
    %>
</html>