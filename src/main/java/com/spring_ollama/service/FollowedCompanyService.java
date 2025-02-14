package com.spring_ollama.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_ollama.entity.FollowedCompany;
import com.spring_ollama.repo.FollowedCompanyRepository;

@Service
public class FollowedCompanyService {
    @Autowired
    private FollowedCompanyRepository followedCompanyRepository;

    public List<FollowedCompany> getFollowedCompanies(Long userId) {
        return followedCompanyRepository.findByUserId(userId);
    }

    public FollowedCompany followCompany(FollowedCompany followedCompany) {
        return followedCompanyRepository.save(followedCompany);
    }
}