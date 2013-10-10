<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- 
    Document   : index
    Created on : Sep 19, 2013, 3:53:21 PM
    Author     : New
--%>

<%@page import="slmo.registration.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        if (request.getParameter("logout") != null && request.getParameter("logout").equals("true")) {
            session.removeAttribute("user");
            out.print("You are logged out");
        } else {
            out.print("You are logged in as " + user.getName());

            out.print("    <a href=\"index.jsp?logout=true\">logout</a>");
        }

    }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />        
        <title>Home- SLOMF</title>
        <link rel="shortcut icon" href="images/logo.png"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="css/clockp.js"></script>
        <script type="text/javascript" src="css/clockh.js"></script> 
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

            <div class="header">
                <div class="logo"><a href="#"><img src="css/images/logo.gif" alt="" title="" border="0" /></a></div>

                <div class="right_header">Welcome to Mathematics Olympiad Foundation!<br>
                </div>
                <div id="clock_a"></div>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a class="current" href="./">Home</a></li>
                        <li><a href="#">News</a></li>
                        <li><a href="#">Register</a>
                            <ul>
                                <li><a href="register.jsp" title="">As a Private Applicant</a></li>
                                <li><a href="school.jsp" title="">As a School</a></li>
                            </ul>
                        </li>
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="contactUs.jsp">Contact us</a></li>
                    </ul>
                </div> 
                <div class="center_content">
                    <div class="left_content">

                        <div class="sidebar_search">
                            <form>
                                <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
                                <input type="image" class="search_submit" src="css/images/search.png" />
                            </form>            
                        </div>

                        <div class="sidebarmenu">            
                            <a class="menuitem submenuheader" href="">Add</a>
                            <div class="submenu">
                                <ul>
                                    <li><a href="">Student</a></li>
                                    <li><a href="">School</a></li>
                                </ul>
                            </div>
                            <a class="menuitem" href="" >Centre Information</a>
                            <a class="menuitem" href="">Centre Statistics</a>
                            <a class="menuitem" href="">Assign Centres</a>
                            <a class="menuitem_green" href="">Send Admission Cards</a>
                            <a class="menuitem_red" href="login.html" onclick="return message();">Review Answer Scripts</a>
                        </div>


                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h3>User help desk</h3>
                                <img src="css/images/info.png" alt="" title="" class="sidebar_icon_right" />
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                </p>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>

                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h4>Important notice</h4>
                                <img src="css/images/notice.png" alt="" title="" class="sidebar_icon_right" />
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                </p>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>

                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h5>Download photos</h5>
                                <img src="css/images/photo.png" alt="" title="" class="sidebar_icon_right" />
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                </p>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>  

                        <div class="sidebar_box">
                            <div class="sidebar_box_top"></div>
                            <div class="sidebar_box_content">
                                <h3>To do List</h3>
                                <img src="css/images/info.png" alt="" title="" class="sidebar_icon_right" />
                                <ul>
                                    <li>Check registered schools and students</li>
                                    <li>Insert school details manually</li>
                                    <li>Assign examination centres to the applicants</li>
                                    <li>Send admission cards</li>
                                    <li>Finalize coding this shit</li>
                                    <li>Upload the source code</li>
                                    <li>Explain about this software to CG <strong>(CRITICAL)</strong></li>
                                </ul>                
                            </div>
                            <div class="sidebar_box_bottom"></div>
                        </div>


                    </div>  

                    <div class="right_content">            

                        <h2>Products Categories Settings</h2> 


                        <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
                            <thead>
                                <tr>
                                    <th scope="col" class="rounded-company"></th>
                                    <th scope="col" class="rounded">Product</th>
                                    <th scope="col" class="rounded">Details</th>
                                    <th scope="col" class="rounded">Price</th>
                                    <th scope="col" class="rounded">Date</th>
                                    <th scope="col" class="rounded">Edit</th>
                                    <th scope="col" class="rounded-q4">Delete</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <td colspan="6" class="rounded-foot-left"><em>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</em></td>
                                    <td class="rounded-foot-right">&nbsp;</td>

                                </tr>
                            </tfoot>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox" name="" /></td>
                                    <td>Product name</td>
                                    <td>details</td>
                                    <td>150$</td>
                                    <td>12/05/2010</td>

                                    <td><a href="#"><img src="css/images/user_edit.png" alt="" title="" border="0" /></a></td>
                                    <td><a href="#" class="ask"><img src="css/images/trash.png" alt="" title="" border="0" /></a></td>
                                </tr>

                                <tr>
                                    <td><input type="checkbox" name="" /></td>
                                    <td>Product name</td>
                                    <td>details</td>
                                    <td>150$</td>
                                    <td>12/05/2010</td>

                                    <td><a href="#"><img src="css/images/user_edit.png" alt="" title="" border="0" /></a></td>
                                    <td><a href="#" class="ask"><img src="css/images/trash.png" alt="" title="" border="0" /></a></td>
                                </tr> 

                                <tr>
                                    <td><input type="checkbox" name="" /></td>
                                    <td>Product name</td>
                                    <td>details</td>
                                    <td>150$</td>
                                    <td>12/05/2010</td>

                                    <td><a href="#"><img src="css/images/user_edit.png" alt="" title="" border="0" /></a></td>
                                    <td><a href="#" class="ask"><img src="css/images/trash.png" alt="" title="" border="0" /></a></td>
                                </tr>

                                <tr>
                                    <td><input type="checkbox" name="" /></td>
                                    <td>Product name</td>
                                    <td>details</td>
                                    <td>150$</td>
                                    <td>12/05/2010</td>

                                    <td><a href="#"><img src="css/images/user_edit.png" alt="" title="" border="0" /></a></td>
                                    <td><a href="#" class="ask"><img src="css/images/trash.png" alt="" title="" border="0" /></a></td>
                                </tr>  
                                <tr>
                                    <td><input type="checkbox" name="" /></td>
                                    <td>Product name</td>
                                    <td>details</td>
                                    <td>150$</td>
                                    <td>12/05/2010</td>

                                    <td><a href="#"><img src="css/images/user_edit.png" alt="" title="" border="0" /></a></td>
                                    <td><a href="#" class="ask"><img src="css/images/trash.png" alt="" title="" border="0" /></a></td>
                                </tr>

                                <tr>
                                    <td><input type="checkbox" name="" /></td>
                                    <td>Product name</td>
                                    <td>details</td>
                                    <td>150$</td>
                                    <td>12/05/2010</td>

                                    <td><a href="#"><img src="css/images/user_edit.png" alt="" title="" border="0" /></a></td>
                                    <td><a href="#" class="ask"><img src="css/images/trash.png" alt="" title="" border="0" /></a></td>
                                </tr>    

                            </tbody>
                        </table>

                        <a href="#" class="bt_green"><span class="bt_green_lft"></span><strong>Add new item</strong><span class="bt_green_r"></span></a>
                        <a href="#" class="bt_blue"><span class="bt_blue_lft"></span><strong>View all items from category</strong><span class="bt_blue_r"></span></a>
                        <a href="#" class="bt_red"><span class="bt_red_lft"></span><strong>Delete items</strong><span class="bt_red_r"></span></a> 


                        <h2>Warning Box examples</h2>

                        <div class="warning_box">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.
                        </div>
                        <div class="valid_box">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.
                        </div>
                        <div class="error_box">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.
                        </div>
                        <h2>Nice Form example</h2>

                        <div class="form">
                            <form action="" method="post" class="niceform">

                                <fieldset>
                                    <dl>
                                        <dt><label for="email">Email Address:</label></dt>
                                        <dd><input type="text" name="" id="" size="54" /></dd>
                                    </dl>
                                    <dl>
                                        <dt><label for="password">Password:</label></dt>
                                        <dd><input type="text" name="" id="" size="54" /></dd>
                                    </dl>


                                    <dl>
                                        <dt><label for="gender">Select categories:</label></dt>
                                        <dd>
                                            <select size="1" name="gender" id="">
                                                <option value="">Select option 1</option>
                                                <option value="">Select option 2</option>
                                                <option value="">Select option 3</option>
                                                <option value="">Select option 4</option>
                                                <option value="">Select option 5</option>
                                            </select>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><label for="interests">Select tags:</label></dt>
                                        <dd>
                                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Web design</label>
                                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Business</label>
                                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Simple</label>
                                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Clean</label>
                                        </dd>
                                    </dl>

                                    <dl>
                                        <dt><label for="color">Select type</label></dt>
                                        <dd>
                                            <input type="radio" name="type" id="" value="" /><label class="check_label">Basic</label>
                                            <input type="radio" name="type" id="" value="" /><label class="check_label">Medium</label>
                                            <input type="radio" name="type" id="" value="" /><label class="check_label">Premium</label>
                                        </dd>
                                    </dl>



                                    <dl>
                                        <dt><label for="upload">Upload a File:</label></dt>
                                        <dd><input type="file" name="upload" id="upload" /></dd>
                                    </dl>

                                    <dl>
                                        <dt><label for="comments">Message:</label></dt>
                                        <dd><textarea name="comments" id="comments" rows="5" cols="36"></textarea></dd>
                                    </dl>

                                    <dl>
                                        <dt><label></label></dt>
                                        <dd>
                                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">I agree to the <a href="#">terms &amp; conditions</a></label>
                                        </dd>
                                    </dl>

                                    <dl class="submit">
                                        <input type="submit" name="submit" id="submit" value="Submit" />
                                    </dl>



                                </fieldset>

                            </form>  
                        </div>
                    </div><!-- end of right content-->


                </div>   <!--end of center content -->

                <div class="clear"></div>


                <p class="para" align="right"><font size="5px">Follow Us:</font></p>


                <a href="#"><img src="images/social-link-1.jpg" alt="" align="right"/></a>
                <a href="https://www.facebook.com/photo.php?fbid=531306523587668&set=pb.285656058152717.-2207520000.1380090385.&type=3&theater" target="new"><img src="images/social-link-2.jpg" alt="" align="right"/></a></li>
                <a href="#"><img src="images/social-link-3.jpg" alt="" align="right"/></a>
                <a href="#"><img src="images/social-link-4.jpg" alt="" align="right"/></a>

           
        </div> <!--end of main content-->


        <div class="footer">

            <div class="left_footer"><p>Sri Lanka Mathematics Olympiad Foundation | 2013.09.21 | Contact: +94 71 546 517 8</p></div>
            <div class="right_footer"><a href="http://indeziner.com"><img src="css/images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>

        </div>

        </div>		
    </body>
</html>