package com.mapping.jsonmap.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.mapping.jsonmap.domain.MapperJson;
import com.mapping.jsonmap.domain.MapperData;

import com.mapping.jsonmap.service.MapperService;
import com.mapping.jsonmap.repository.MapperJsonRepository;
import com.mapping.jsonmap.repository.MapperRepository;
import com.mapping.jsonmap.service.MapperDataService;

@Service
public class MapperServiceImpl implements MapperService {

    private final Logger logger = LoggerFactory.getLogger(MapperServiceImpl.class);

    private final MapperJsonRepository mapperJsonRepository;

    private final MapperRepository mapperRepository;

    private final MapperDataService mapperDataService;

    public MapperServiceImpl(MapperRepository mapperRepository, MapperJsonRepository mapperJsonRepository, MapperDataService mapperDataService) {
        this.mapperRepository = mapperRepository;
        this.mapperJsonRepository = mapperJsonRepository;
        this.mapperDataService = mapperDataService;

    }

    @Override
    public MapperJson createMapper(MapperJson mapperJson) {

        MapperJson savedMongo = mapperJsonRepository.save(mapperJson);
        String mongoId = savedMongo.getId();

        Map<String, Object> data = mapperJson.getData();

        Map<String, Object> metaData = (Map<String, Object>) data.get("metaData");

        String mapType = null;
        String bpmName = null;

        if (metaData != null) {
            mapType = (String) metaData.get("mapType");
            bpmName = (String) metaData.get("bpmName");
        }

        MapperData mapperData = new MapperData();
        mapperData.setMongoId(mongoId);
        mapperData.setMapperType(mapType);
        mapperData.setBpmName(bpmName);
        mapperData.setMapperId("MAP001");

        mapperRepository.save(mapperData);

        return savedMongo;
    }

    @Override
    public List<MapperJson> getAllMappers() {
        return mapperJsonRepository.findAll();
    }

    @Override
    public MapperJson updateMapper(String id, MapperJson mapperJson) {

        MapperJson existing = mapperJsonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data not found with id: " + id));

        if (mapperJson.getData() != null) {
            existing.setData(mapperJson.getData());
        }

        MapperJson updatedMongo = mapperJsonRepository.save(existing);

        Map<String, Object> data = updatedMongo.getData();
        Map<String, Object> metaData = (Map<String, Object>) data.get("metaData");

        String mapType = null;
        String bpmName = null;

        if (metaData != null) {
            mapType = (String) metaData.get("mapType");
            bpmName = (String) metaData.get("bpmName");
        }

        MapperData mapperData = mapperDataService.findMapperDataByMongoId(id);
        logger.info("the update the mapperdata {}", mapperData);
        mapperData.setMapperType(mapType);
        mapperData.setBpmName(bpmName);
        mapperData.setLastModifiedDate(Instant.now());
        mapperRepository.save(mapperData);
        return updatedMongo;
    }

    @Override
    public void deleteMapper(String id) {
        mapperJsonRepository.deleteById(id);
    }

}
