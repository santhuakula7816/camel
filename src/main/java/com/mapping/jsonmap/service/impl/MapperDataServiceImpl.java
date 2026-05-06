package com.mapping.jsonmap.service.impl;

import org.springframework.stereotype.Service;

import com.mapping.jsonmap.domain.MapperData;
import com.mapping.jsonmap.repository.MapperRepository;
import com.mapping.jsonmap.service.MapperDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MapperDataServiceImpl implements MapperDataService {

    private final Logger logger = LoggerFactory.getLogger(MapperDataServiceImpl.class);

    private final MapperRepository mapperRepository;

    public MapperDataServiceImpl(MapperRepository mapperRepository) {
        this.mapperRepository = mapperRepository;
    }

    @Override
    public MapperData findByMongoId(String Id) {
        logger.info("Request to find by MongoId: {}", Id);
        return mapperRepository.findByMongoId(Id);
    }

}
