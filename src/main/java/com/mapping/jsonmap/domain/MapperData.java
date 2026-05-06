package com.mapping.jsonmap.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "mapper")
public class MapperData extends AbstractAuditingEntity<Long>{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @Column(name = "mongo_id")
    private String mongoId;

    @Column(name = "mapper_id")
    private String mapperId;

    @Column(name = "mapper_type")
    private String mapperType;

    @Column(name = "bpm_name")
    private String bpmName;

    public MapperData(String mongoId, String bpmName, Long id, String mapperId, String mapperType) {
        this.bpmName = bpmName;
        this.id = id;
        this.mapperId = mapperId;
        this.mapperType = mapperType;
        this.mongoId = mongoId;
    }

    public MapperData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMapperId() {
        return mapperId;
    }

    public void setMapperId(String mapperId) {
        this.mapperId = mapperId;
    }

    public String getMapperType() {
        return mapperType;
    }

    public void setMapperType(String mapperType) {
        this.mapperType = mapperType;
    }

    public String getBpmName() {
        return bpmName;
    }

    public void setBpmName(String bpmName) {
        this.bpmName = bpmName;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append("mapperData [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
        if (mapperId != null){
            builder.append("mapperId=");
			builder.append(mapperId);
			builder.append(", ");
        }
        if (mapperType != null){
            builder.append("mapperType=");
			builder.append(mapperType);
			builder.append(", ");
        }
         if (bpmName != null){
            builder.append("bpmName=");
			builder.append(bpmName);
			builder.append(", ");
        }
        if (mongoId != null){
            builder.append("mongoId=");
            builder.append(mongoId);
            builder.append(", ");
        }
        builder.append("]");
		return builder.toString();
}

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

}