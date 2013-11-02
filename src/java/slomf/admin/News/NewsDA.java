package slomf.admin.News;

import slomf.api.Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NewsDA {
    private static ArrayList<NewsItem> news =null;

    public static ArrayList<NewsItem> getNews() {
        if(news==null||news.isEmpty()){
            processNews();
        }
        return news;
    }
    public static void setNews(ArrayList<NewsItem> news) {
        NewsDA.news = news;
    }
    public static NewsItem getArticleByName(String title){
        for(int i=0;i<news.size();i++)
            if(news.get(i).getTitle().equals(title))
                return news.get(i);
        return null;
    }
    public static void addNews(String news, String title) {
        try {
            Connection con = DatabaseConnectionHandler.createConnection();

            String queryCheck = "INSERT INTO news (news, title) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, news);
            ps.setString(2, title);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
    }
    public static void deleteNews(int id) {
        Connection con;

        try {
            con = DatabaseConnectionHandler.createConnection();
            String queryCheck = "DELETE FROM news WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, id);
            ps.execute();
             con.close();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
    }
    public static void processNews() {
        ArrayList<NewsItem> newsList = new ArrayList<NewsItem>();
        try {
            Connection con = DatabaseConnectionHandler.createConnection();
            String queryCheck = "SELECT * FROM news ";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ResultSet rs = ps.executeQuery();
            NewsItem item;
            while (rs.next()) {
                item = new NewsItem(rs.getString("news"), rs.getString("title"), rs.getInt("id"),rs.getBoolean("show_news"),rs.getBoolean("main_news"),rs.getBoolean("article"));
                newsList.add(item);
            }
            Comparator<NewsItem> comparator = new Comparator<NewsItem>() {
                @Override
                public int compare(NewsItem n1, NewsItem n2) {
                    return n2.getId() - n1.getId();
                }
            };
            con.close();
            Collections.sort(newsList,comparator);
            news = newsList;
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
        NewsDA.setNews(newsList);
    }
    public static void updateNews(NewsItem item){
        try {
            Connection con = DatabaseConnectionHandler.createConnection();

            String queryCheck = "UPDATE news "
                    + "SET show_news = ? , main_news = ? , article = ? , news = ? , title = ? "
                    + "WHERE id = ? ";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setBoolean(1, item.isShow());
            ps.setBoolean(2, item.isMain());
            ps.setBoolean(3, item.isArticle());
            ps.setString(4, item.getNews());
            ps.setString(5, item.getTitle());
            ps.setInt(6, item.getId());
            ps.executeUpdate();
             con.close();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
    }
}
