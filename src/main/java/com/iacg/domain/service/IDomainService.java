package com.iacg.domain.service;

import java.util.List;

import com.iacg.domain.model.Domain;

public interface IDomainService {
    
    List<Domain> findAll();
    Domain findById(String id);
}

