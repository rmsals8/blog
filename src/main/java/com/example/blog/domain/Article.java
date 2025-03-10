package com.example.blog.domain;


import jakarta.persistence.Id; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;

    @Column(name ="title",nullable = false)
    private String tilte;

    @Column(name="content",nullable = false)
    private String content;
    

    public void update(String title,String content){
        this.tilte = title;
        this.content = content;
    }
}
