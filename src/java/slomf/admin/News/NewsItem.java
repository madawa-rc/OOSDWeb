package slomf.admin.News;

public class NewsItem {
    public String news;
    public int id;
    public boolean show;

    public NewsItem(String news, int id, boolean show) {
        this.news = news;
        this.id = id;
        this.show = show;
    }

    

    public int getId() {
        return id;
    }

    public String getNews() {
        return news;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }
    
}
