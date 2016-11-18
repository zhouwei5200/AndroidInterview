package com.guowei.android.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhoug on 2016/8/29.
 */
public class CommitBean extends BmobObject {
    private  String article_url;
    private  String article_type;
    private  String article_time;
    private  String article_author;
    private  String article_name;

    public String getArticle_url() {
        return article_url;
    }

    public String getArticle_type() {
        return article_type;
    }

    public String getArticle_time() {
        return article_time;
    }

    public String getArticle_author() {
        return article_author;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public void setArticle_time(String article_time) {
        this.article_time = article_time;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }
}
