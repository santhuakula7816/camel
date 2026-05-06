package com.mapping.jsonmap.repository;
import org.springframework.stereotype.Repository;
import com.mapping.jsonmap.domain.MapperData;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MapperRepository extends JpaRepository<MapperData, Long> {
    
    public MapperData findByMongoId(String Id);
}
