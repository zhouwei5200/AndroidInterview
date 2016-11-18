package com.guowei.android.model;


import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zhoug on 2016/8/5.
 */
public class AndroidBean extends BmobObject {
    private  String articleUrl;
    private  String article_name;
    private  String article_author;
    private  String article_time;
    private  int article_star;

    public String getArticle_time() {
        return article_time;
    }



    public void setArticle_time(String article_time) {
        this.article_time = article_time;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public String getArticle_name() {
        return article_name;
    }

    public String getArticle_author() {
        return article_author;
    }

    public int getArticle_star() {
        return article_star;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public void setArticle_star(int article_star) {
        this.article_star = article_star;
    }


}
