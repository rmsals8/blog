package com.example.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog.domain.Article;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.dto.UpdateArticleRequest;
import com.example.blog.repository.BlogRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class BlogService {
    
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id,UpdateArticleRequest request){
        // id 에 따른 글을 가져오기 
        Article article = blogRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("not found: "+id));
        // UpdateArticleRequest 로 받아온 컨텐츠를 , Article 의 update 메소드를 사용해서 , 넣기 
        article.update(request.getTitle(), request.getContent());
        
        return article;
    }
}
