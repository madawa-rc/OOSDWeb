package News;

import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NewsDA {
    
    
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
    public static void modifyNews(String message, int id) {
        Connection con;

        try {
            con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "UPDATE news "
                    + "SET news = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, message);
            ps.setInt(2, id);
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
                item = new NewsItem(rs.getString("news"), rs.getInt("id"));
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
        NewsMain.setNews(newsList);
    }
    public static void setMainNews(int id){
        NewsMain.mainNews=null;
        ArrayList<NewsItem> list = NewsMain.getNews();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id)
                NewsMain.mainNews=list.get(i);
        }
    }
}
