package com.restapi.restapi.repository;

import com.restapi.restapi.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findByCid(Long cid);
}
