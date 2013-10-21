package slomf.admin.News;

public class NewsItem {
    public String news;
    public String title;
    public int id;
    public boolean show;
    public boolean main;
    public boolean article;

    public NewsItem(String news, String title, int id, boolean show, boolean main, boolean article) {
        this.news = news;
        this.title = title;
        this.id = id;
        this.show = show;
        this.main = main;
        this.article = article;
    }



    public boolean isArticle() {
        return article;
    }

    public String getTitle() {
        return title;
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
