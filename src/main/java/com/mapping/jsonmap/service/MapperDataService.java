package com.mapping.jsonmap.service;
import com.mapping.jsonmap.domain.MapperData;

public interface MapperDataService {

    MapperData findMapperDataByMongoId(String id);
}
