package com.spring_ollama.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_ollama.entity.FollowedCompany;
import com.spring_ollama.service.FollowedCompanyService;

@RestController
@RequestMapping("/api/followed-companies")
@CrossOrigin(origins = "*")
public class FollowedCompanyController {
    @Autowired
    private FollowedCompanyService followedCompanyService;

    @GetMapping("/{userId}")
    public List<FollowedCompany> getFollowedCompanies(@PathVariable Long userId) {
        return followedCompanyService.getFollowedCompanies(userId);
    }

    @PostMapping
    public FollowedCompany followCompany(@RequestBody FollowedCompany followedCompany) {
    	System.out.println(followedCompany.getCompany());
    	System.out.println(followedCompany.getUser());

        return followedCompanyService.followCompany(followedCompany);
    }
}
