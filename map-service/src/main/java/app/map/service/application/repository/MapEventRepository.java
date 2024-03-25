package app.map.service.application.repository;

import app.map.service.application.entity.MapEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapEventRepository extends MongoRepository<MapEvent, String> {
}
