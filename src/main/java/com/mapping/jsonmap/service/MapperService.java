package com.mapping.jsonmap.service;


import com.mapping.jsonmap.domain.MapperJson;
import java.util.List;

public interface MapperService {

    MapperJson createMapper(MapperJson mapperJson);

    List<MapperJson> getAllMappers();

    MapperJson updateMapper(String id, MapperJson mapperJson);

    void deleteMapper(String id);
    
}
