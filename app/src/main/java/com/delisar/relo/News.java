package com.delisar.relo;

public class News {
    private int id;
    private int image;
    private String titleNews;
    private String bodyNews;

    public News(int id, int image, String titleNews, String bodyNews) {
        this.id = id;
        this.image = image;
        this.titleNews = titleNews;
        this.bodyNews = bodyNews;
    }

    public int getId(){
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public String getBodyNews() {
        return bodyNews;
    }
}
