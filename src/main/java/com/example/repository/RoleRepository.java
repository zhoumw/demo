package com.example.repository;

import com.example.domain.Role;
import com.example.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhoumw on 2016/12/27.
 */
@CacheConfig(cacheNames = "com.example.repository.RoleRepository")
public interface RoleRepository extends JpaRepository<Role,Long>{
    @Cacheable(key = "#p0")
    Role findByName(String name);

    @CachePut(key = "#p0.name")
    Role save(Role role);

    @CacheEvict(key = "#p0.name")
    void delete(Role role);

}

