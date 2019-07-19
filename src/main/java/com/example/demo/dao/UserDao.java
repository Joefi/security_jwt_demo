package com.example.demo.dao;

import com.example.demo.entity.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {
    AppUser findUserByName(String username);
}
