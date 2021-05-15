package com.restapi.restapi.repository;

import com.restapi.restapi.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByuid(Long uid);
}
