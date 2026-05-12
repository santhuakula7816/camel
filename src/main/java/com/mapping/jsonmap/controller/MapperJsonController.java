package com.mapping.jsonmap.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.jsonmap.domain.MapperJson;
import com.mapping.jsonmap.service.MapperService;

@RestController
@RequestMapping("/json")
public class MapperJsonController {

    private final MapperService mapperService;

    public MapperJsonController(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @PostMapping("/create")
    public ResponseEntity<MapperJson> createRack(@RequestBody Map<String, Object> request) {

        MapperJson mapperJson = new MapperJson();
        mapperJson.setData(request);

        MapperJson result = mapperService.save(mapperJson);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllJsons")
    public ResponseEntity<List<MapperJson>> getAllJsons() {
        List<MapperJson> mapperJson = mapperService.getAllJsons();
        return ResponseEntity.ok(mapperJson);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MapperJson> update(@PathVariable(required = false) final String id, @RequestBody MapperJson mapperJson) {
        MapperJson mapperJson1 = mapperService.update(id, mapperJson);
        return ResponseEntity.ok(mapperJson1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@RequestParam String id) {
        mapperService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
