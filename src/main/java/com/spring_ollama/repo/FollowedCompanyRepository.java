package com.spring_ollama.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_ollama.entity.FollowedCompany;

public interface FollowedCompanyRepository extends JpaRepository<FollowedCompany, Long> {
    List<FollowedCompany> findByUserId(Long userId);
}