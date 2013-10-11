<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : login
    Created on : Sep 22, 2013, 5:16:45 PM
    Author     : Kasun
--%>
<%@page import="slmo.registration.User"%>
<%@page import="slmo.registration.School"%><font color="#ff0000"></font>
<%
    User user = (User) session.getAttribute("user");
    boolean loggedIn = false;
    if (user != null) {
        loggedIn = true;
        response.setHeader("Refresh", "3; URL=" + user.getLink());
    }
    School school = (School) session.getAttribute("schoolObject");

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="css/jquery.min.js"></script>
        <script type="text/javascript" src="css/ddaccordion.js"></script>
        <script type="text/javascript">
            ddaccordion.init({
                headerclass: "submenuheader", //Shared CSS class name of headers group
                contentclass: "submenu", //Shared CSS class name of contents group
                revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
                mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
                collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
                defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
                onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
                animatedefault: false, //Should contents open by default be animated into view?
                persiststate: true, //persist state of opened contents within browser session?
                toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
                togglehtml: ["suffix", "<img src='css/images/plus.gif' class='statusicon' />", "<img src='css/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
                animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
                oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
                    //do nothing
                }
            })
        </script>

        <script type="text/javascript" src="css/jconfirmaction.jquery.js"></script>
        <script type="text/javascript">
	
            $(document).ready(function() {
                $('.ask').jConfirmAction();
            });
	
        </script>

        <script language="javascript" type="text/javascript" src="css/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="css/niceforms-default.css" />

    </head>
    <body>
        <div id="main_container">

            <div class="header_login">

            </div>


            <div class="box-2">
                <strong>
                    <%
                        if (loggedIn) {
                            out.print("<h2 align=\"center\">You are logged in!</h2><br>");
                            out.print("<p align=\"center\">Redirecting you now.....</p>");
                        } else {

                    %><br>
                </strong>
                <a href="#" class="forgot_pass">Forgot password</a>
                <strong>
                        <font color="#ff0000" size="2px">
                            <%
                                String msg = request.getParameter("id");
                                if (msg != null) {
                                    out.print("<p align=\"center\">" + msg + "</p>");
                                }
                            %>
                        </font>
                        <%
                            out.print("<h3>Enter your Login details</h3>");
                        %><br></br>
                </strong>

                <form name="login" method="post" action="SchoolLoginServlet" id="ContactForm">

                    <fieldset>
                        <dl>
                            <dt><label for="email">Email:</label></dt>
                            <dd><input type="text" name="email" id="" size="25" /></dd>
                        </dl>
                        <dl>
                            <dt><label for="password">Password:</label></dt>
                            <dd><input type="password" name="password" id="" size="25" /></dd>
                        </dl>

                        <dl>
                            <dt><label></label></dt>
                            <dd>
                                <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Remember me</label>
                            </dd>
                        </dl>

                        <dl class="submit">
                            <input type="submit" name="submit" class="button" value="Login" />
                            <input type="reset" value="Clear" class="button"/>
                        </dl>

                    </fieldset>

                </form>

                <%}
                %>
            </div>  



            <div class="footer_login">

                <div class="left_footer_login">SLOMF ADMIN PANEL | Powered by Fiontar</div>
                <div class="right_footer_login"><img src="css/images/fiontar.png" alt="" title="" border="0" /></div>

            </div>

        </div>		
    </body>
</html>