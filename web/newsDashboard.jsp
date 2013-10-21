<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="slomf.admin.News.NewsItem"%>
<%@page import="slomf.admin.News.NewsDA"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : schoolDashboard
    Created on : 23-Sep-2013, 21:36:04
    Author     : Madawa
--%>
<%@page import="slomf.registration.School"%>
<%@page import="java.util.ArrayList"%>
<%@page import="slomf.registration.User"%>
<%
    response.setCharacterEncoding("UTF-8");
    User user = (User) session.getAttribute("user");
    if (user == null || !user.getName().equals("Admin")) {
        request.getSession().removeAttribute("user");
        response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Administrator!");
    } else {
        NewsDA.processNews();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ADMIN PANEL</title>
        <link rel="shortcut icon" href="images/logo.png"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="css/clockp.js"></script>
        <script type="text/javascript" src="css/clockh.js"></script> 
        <script type="text/javascript" src="css/jquery.min.js"></script>
        <script type="text/javascript" src="css/ddaccordion.js"></script>
        <script type="text/javascript"
            src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML">
        </script>
        <script type="text/javascript">
            function edit(){
                var table  = document.getElementById('rounded-corner');
                for (var n=0; n<table.rows.length; n++) {
                    if(table.rows[n].cells[4].style.display=='none'){
                        table.rows[n].cells[4].style.display='block';
                        table.rows[n].cells[3].style.display='none';
                        document.getElementById('editButton').disabled = "disabled";
                    }
                    else{
                        table.rows[n].cells[4].style.display='none';
                        table.rows[n].cells[3].style.display='block';
                    }
                }
            }
        </script>
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
                oninit: function(headers, expandedindices) { //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose: function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
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
        <script type="text/javascript">
            function message() {
                var result = confirm("Are you really want to do this?");
                return result;
            }
        </script>

    </head>
    <body>
        <div id="main_container">

            <div class="header">
                <div class="logo"><a href="#"><img src="css/images/logo.png" alt="" title="" border="0" /></a></div>

                <%
                    if (user != null) {
                %>
                <div class="right_header">Welcome Back! <a href="#">My Account</a> | <a href="#">Settings</a> | 
                    <a href = "logout.jsp" class ="logout">Logout</a>
                </div>
                <%                    } else
                        out.print("<div class=\"right_header\"></div>");
                %>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a href="index.jsp">User Home<!--[if IE 7]><!--></a><!--<![endif]-->
                        </li>
                        <li><a class="current" href="newsDashboard.jsp">Add News<!--[if IE 7]><!--></a><!--<![endif]-->
                        </li>
                        <li><a  href="<%=user.getLink()%>">Dashboard</a>
                        </li>
                            
                    </ul>
                </div> 
                <div class="center_content">
                    <%@ include file="adminLeftBar.html" %>
                    
                    <%
                        if (NewsDA.getNews() != null) {
                            ArrayList<NewsItem> newsList = NewsDA.getNews();
                    %>
                    <div class="right_content">
                            <h1>Add New News Item</h1>
                        <form action="NewsServlet" method="post" >
                            One line title<br></br>
                            <input name="newTitle" size="101" /><br></br>
                            Text
                            <textarea name="newNews" rows =10 cols =75 style="resize:vertical"></textarea><br></br>
                            <input type="submit" value="Submit" class="button"/>
                        </form>
                        <br></br>
                        <h2>
                            HTML
                        </h2>
                        <p>
                            &lt h1&gt text &lt/h1&gt for Heading 1 <br></br>
                            &lt p&gt text &lt/p&gt for Paragraph <br></br>
                            &lt br&gt &lt/br&gt  for New Line <br></br>
                            &lt img src="Uploads/imageName"&gt &lt/img&gt for images <br></br> 
                            &lt a href="link"&gt text&lt /a&gt for links <br></br>
                        </p>
                        <h2>
                            \( \LaTeX \)
                        </h2>
                            &#36 &#36 formula &#36 &#36 and &#92 &#91 formula &#92 &#93 for displayed mathematics <br></br>
                            &#92 &#40 formula &#92 &#41 for inline mathematics <br></br>
                            For \( \LaTeX \) symbols <a href="http://detexify.kirelabs.org/classify.html" target="new"> click here</a>.
                            
                        <h1>Edit News Items</h1>
                        <form name="myform" action="NewsServlet" method="post">
                            <input id ="editButton" type="button" value="Edit" onclick="edit();" class="button"/>
                            <br></br>
                            <table id="rounded-corner">
                                <thead>
                                    <tr>
                                        <th scope="col" class="rounded">Main</th>
                                        <th scope="col" class="rounded">News</th>
                                        <th scope="col" class="rounded">Article</th>
                                        <th scope="col" class="rounded">NewsItem</th>
                                        <th scope="col" class="rounded">Edit</th>
                                        <th scope="col" class="rounded">Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (int i = 0; i < newsList.size(); i++) {
                                            NewsItem n = newsList.get(i);
                                    %>
                                    <tr>
                                        <td>
                                            <input type="checkbox" name=<%="main" + n.getId() %> <%if(n.isMain()) out.print("checked=\"true\""); %>/>
                                        </td>
                                        <td>      
                                            <input type="checkbox" name=<%="show" + n.getId() %> <%if(n.isShow()) out.print("checked=\"true\""); %> />
                                        </td>
                                        <td>      
                                            <input type="checkbox" name=<%="article" + n.getId() %> <%if(n.isArticle()) out.print("checked=\"true\""); %> />
                                        </td>
                                        <td>      
                                            <%
                                            out.print(n.getNews()+"<br></br>");
                                            %>
                                        </td>
                                        <td>
                                            <textarea id="editCol" name="<%="editNews" + n.getId() %>" rows=1 cols =55 style="resize:vertical;" ><%=n.getNews()%></textarea><br><br>
                                            <input type="hidden" name="<%="editTitle" + n.getId() %>" value ="<%=n.getTitle()%>" />
                                        </td>
                                        <td>
                                            <input type="checkbox" name=<%="delete" + n.getId() %> />
                                        </td>
                                    </tr>     
                                    <%
                                        }
                                    %>    

                                </tbody>
                            </table>
                            <br></br>
                                  <input type="submit" value="Submit" class="button"/>
                        </form>

                    </div><!-- end of right content-->
                    <%} %>
                </div>   <!--end of center content -->        
                <div class="clear"></div>
            </div> <!--end of main content-->
            <div class="footer">
                <div class="left_footer">SLOMF ADMIN PANEL | Powered by Fiontar</div>
                <div class="right_footer"><a href="http://indeziner.com"><img src="css/images/fiontar.png"/></a></div>
            </div>
        </div>		
    </body>
    <% }%>
</html>
<script type="text/javascript">
    window.onload=edit();
</script>