package com.geekbrains.gbrestdemo.services.interfaces;

import com.geekbrains.gbrestdemo.entities.SystemUser;
import com.geekbrains.gbrestdemo.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(SystemUser systemUser);
}
