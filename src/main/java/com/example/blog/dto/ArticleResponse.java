package com.example.blog.dto;

import com.example.blog.domain.Article;

import lombok.Data;

@Data
public class ArticleResponse {

    private final String title;

    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTilte();
        this.content =article.getContent();
    }
    
}
