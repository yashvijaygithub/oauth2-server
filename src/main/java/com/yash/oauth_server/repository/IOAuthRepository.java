package com.yash.oauth_server.repository;

import com.yash.oauth_server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOAuthRepository extends JpaRepository<Users, String> {
    Users findByUsername(String username);
}
