package News;

public class NewsItem {
    public String news;
    public int id;

    public NewsItem(String news, int id) {
        this.news = news;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNews() {
        return news;
    }
    
}
