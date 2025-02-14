package com.spring_ollama.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_ollama.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
