package com.sparta.springtask1.repository;

import com.sparta.springtask1.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByRefreshToken(String token);
}