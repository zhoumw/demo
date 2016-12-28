package com.example.service;

import com.example.domain.User;

/**
 * Created by zhoumw on 2016/12/28.
 */
public interface UserService {

    public User findByName(String name);

    public void save(User user);

    public void delete(User user);

    void test();
}
