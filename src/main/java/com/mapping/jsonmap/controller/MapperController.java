package com.mapping.jsonmap.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.jsonmap.domain.MapperJson;
import com.mapping.jsonmap.service.MapperService;

@RestController
@CrossOrigin(origins = "http://localhost:8085")
@RequestMapping("/api/mappers")
public class MapperController {

    private final MapperService mapperService;

    public MapperController(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @PostMapping
    public ResponseEntity<MapperJson> createMapper(@RequestBody Map<String, Object> request) {

        MapperJson mapperJson = new MapperJson();
        mapperJson.setData(request);

        MapperJson result = mapperService.createMapper(mapperJson);

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<MapperJson>> getAllMappers() {
        List<MapperJson> mappers = mapperService.getAllMappers();
        return ResponseEntity.ok(mappers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MapperJson> updateMapper(@PathVariable(required = true) final String id, @RequestBody MapperJson mapperJson) {
        MapperJson updatedMapper = mapperService.updateMapper(id, mapperJson);
        return ResponseEntity.ok(updatedMapper);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteMapper(@RequestBody String id) {
        mapperService.deleteMapper(id);
        return ResponseEntity.noContent().build();
    }

}
