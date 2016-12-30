package com.example.service;

import com.example.domain.Role;

/**
 * Created by zhoumw on 2016/12/28.
 */
public interface RoleService {

    public Role findByName(String name);

    public void save(Role role);

    public void delete(Role role);

    void test();
}
