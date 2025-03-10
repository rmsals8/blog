package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.Article;

public interface BlogRepository extends JpaRepository<Article,Long> {
    
}
