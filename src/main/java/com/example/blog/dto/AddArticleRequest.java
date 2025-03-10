package com.example.blog.dto;

import com.example.blog.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
        .tilte(title)
        .content(content)
        .build();

    }
    
}
