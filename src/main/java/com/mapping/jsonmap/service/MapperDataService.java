package com.mapping.jsonmap.service;
import com.mapping.jsonmap.domain.MapperData;

public interface MapperDataService {

    public MapperData findByMongoId(String Id);
}