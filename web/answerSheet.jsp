<%-- 
    Document   : answerSheet
    Created on : Oct 7, 2013, 10:04:24 PM
    Author     : Fiontar
--%>

<%@page import="slmo.registration.ResultSheet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>    
    <%
        ResultSheet resultSheet = null;
        resultSheet = (ResultSheet) session.getAttribute("resultSheet");
    %>
    <body>
        <form name="searchForm" method="post" action="GetAnswerScript">
            <p class="para">&nbsp;Search:</font> &nbsp;&nbsp; 
                <input class="input" type="text" value="Index number"
                       onBlur="if (this.value == '')
                           this.value = 'Index number'"
                       onFocus="if (this.value == 'Index number')
                           this.value = ''" name="indexNum">
                <input type="submit" value="Search" class="button">
            </p>
        </form>

        <%
            if (resultSheet != null) {
                String[] rs = resultSheet.getRecords();
                for (int i = 0; i < 30; ++i) {
        %>
        <img src="<% out.print("images/score/" + rs[i] + ".jpg");%>">
        <%
                    if (i == 14) {
                        out.print("<br>");
                    }
                }
                out.print("<br><br><a href=\"\" align=\"center\">Next</a>");
            }
        %>
    </body>
</html>
