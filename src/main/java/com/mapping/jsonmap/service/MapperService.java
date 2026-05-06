package com.mapping.jsonmap.service;


import com.mapping.jsonmap.domain.MapperJson;
import java.util.List;

public interface MapperService {

    public MapperJson save(MapperJson mapperJson);

    public List<MapperJson> getAllJsons();

    public MapperJson update(String Id, MapperJson mapperJson);

    public void delete(String id);
    
}