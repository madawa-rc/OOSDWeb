package News;

import java.util.ArrayList;

public class NewsMain {
    public static NewsItem mainNews=null;
    public static ArrayList<NewsItem> news =null;

    public static NewsItem getMainNews() {
        return mainNews;
    }
    public static ArrayList<NewsItem> getNews() {
        return news;
    }

    public static void setMainNews(NewsItem mainNews) {
        NewsMain.mainNews = mainNews;
    }

    public static void setNews(ArrayList<NewsItem> news) {
        NewsMain.news = news;
    }

    
    
    
    
    
    
}
