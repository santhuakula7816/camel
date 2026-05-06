package com.mapping.jsonmap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mapping.jsonmap.domain.MapperJson;


public interface MapperJsonRepository extends MongoRepository<MapperJson, String> {
    
}