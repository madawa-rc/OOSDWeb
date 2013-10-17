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
        return news;
    }
    public static void setNews(ArrayList<NewsItem> news) {
        NewsDA.news = news;
    }
    
    public static void addNews(String news) {
        try {
            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "INSERT INTO news (news) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, news);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void deleteNews(int id) {
        Connection con;

        try {
            con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "DELETE FROM news WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void processNews() {
        ArrayList<NewsItem> newsList = new ArrayList<NewsItem>();
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "SELECT * FROM news ";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ResultSet rs = ps.executeQuery();
            NewsItem item;
            while (rs.next()) {
                item = new NewsItem(rs.getString("news"), rs.getInt("id"),rs.getBoolean("show_news"),rs.getBoolean("main_news"));
                newsList.add(item);
            }
            Comparator<NewsItem> comparator = new Comparator<NewsItem>() {
                @Override
                public int compare(NewsItem n1, NewsItem n2) {
                    return n2.getId() - n1.getId();
                }
            };
            Collections.sort(newsList,comparator);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        NewsDA.setNews(newsList);
    }
    public static void updateNews(NewsItem item){
        try {
            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE news "
                    + "SET show_news = ? , main_news = ? , news = ? "
                    + "WHERE id = ? ";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setBoolean(1, item.isShow());
            ps.setBoolean(2, item.isMain());
            ps.setString(3, item.getNews());
            ps.setInt(4, item.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
