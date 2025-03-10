package com.example.blog.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.blog.dto.AddUserRequest;
import com.example.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
        .email(dto.getEmail())
        .password(bCryptPasswordEncoder.encode(dto.getPassword())))
        .build().getId();
    }
}
