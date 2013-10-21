<%@page import="slomf.admin.News.NewsDA"%>
<%@page import="slomf.admin.News.NewsItem"%>
<%@page import="java.util.ArrayList"%>
<div class="left_content">
    <div>
        <p>
            <img src ="images/logo2.png"alt="" align="left">
            <font color="white">You got it!</font>                          
        </p>
    </div> 
    <div class="sidebarmenu">            
        <a class="menuitem submenuheader" href="">IMO</a>
        <div class="submenu">
            <ul>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2013">IMO 2013</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2012">IMO 2012</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2011">IMO 2011</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2010">IMO 2010</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2009">IMO 2009</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2008">IMO 2008</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2007">IMO 2007</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2006">IMO 2006</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2005">IMO 2005</a></li>
                <li><a href="http://imo-official.org/team_r.aspx?code=LKA&year=2004">IMO 2004</a></li>
            </ul>
        </div>
        <a class="menuitem submenuheader" href="">SLMO</a>
        <div class="submenu">
            <ul>
                <li><a href="">SLMO 2013</a></li>
                <li><a href="">SLMO 2012</a></li>
                <li><a href="">SLMO 2011</a></li>
            </ul>
        </div>
        <a class="menuitem submenuheader" href="">Articles</a>
        <div class="submenu">
            <ul>
                <%
                    ArrayList<NewsItem> list= null;
                    if (NewsDA.getNews() != null) {
                    list = NewsDA.getNews();
                    for (int i = 0; i < list.size(); i++) {
                        NewsItem item = list.get(i);
                        if (item.isArticle()) {

                %>
                <li><a href="<%="article.jsp?name=" + item.getTitle()%>" ><%=item.getTitle()%></a></li>
                    <%
                            }
                        }
                    }
                    %>
            </ul>
        </div>
        <a class="menuitem" href="" >Our Vision</a>
        <a class="menuitem" href="">Our Mission</a>
    </div>
    <div class="sidebar_box">
        <div class="sidebar_box_top"></div>
        <div class="sidebar_box_content">
            <h3>Latest News</h3>

            <%
                if(list!=null){
                for (int i = 0; i < list.size(); i++) {
                    NewsItem item = list.get(i);
                    if (item.isShow()) {

            %>
            <p><a href="<%="news.jsp#" + item.getTitle()%>" ><%=item.getTitle()%></a></p>
            <%
                    }
                }
                }
            %>               
        </div>
        <div class="sidebar_box_bottom"></div>
    </div>

    <div class="sidebar_box">
        <div class="sidebar_box_top"></div>
        <div class="sidebar_box_content">
            <h3>User help desk</h3>
            <img src="css/images/info.png" alt="" title="" class="sidebar_icon_right" />
            <p>
                Thousands of students love to participate in Mathematics Olympiad every year to improve their knowledge.
                Register today and represent Sri Lanka at the International Mathematical Olympiad!
            </p>                
        </div>
        <div class="sidebar_box_bottom"></div>
    </div>



    <div class="sidebar_box">
        <div class="sidebar_box_top"></div>
        <div class="sidebar_box_content">
            <h3>Follow us</h3>
            <p>
                <a href="#"><img src="images/social-link-1.jpg" style="margin:0 5px"alt="" align="left"/></a>
                <a href="https://www.facebook.com/photo.php?fbid=531306523587668&set=pb.285656058152717.-2207520000.1380090385.&type=3&theater" target="new">
                    <img src="images/social-link-2.jpg" style="margin:0 5px"alt="" align="left"/></a>
                <a href="#"><img src="images/social-link-3.jpg"style="margin:0 5px" alt="" align="left"/></a>
                <a href="#"><img src="images/social-link-4.jpg"style="margin:0 5px" alt="" align="left"/></a>
                <br>
            </p>
        </div>
        <div class="sidebar_box_bottom"></div>
    </div>
</div> <!-- end of left content--> 
