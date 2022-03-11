package com.ex.appapi.models;

import java.util.List;

public class ListNews {

private List<News> articles ;
private int totalResults;



    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }


}
