package slomf.admin.News;

public class NewsItem {
    public String news;
    public int id;
    public boolean show;
    public boolean main;

    public NewsItem(String news, int id, boolean show, boolean main) {
        this.news = news;
        this.id = id;
        this.show = show;
        this.main = main;
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

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
    
}
