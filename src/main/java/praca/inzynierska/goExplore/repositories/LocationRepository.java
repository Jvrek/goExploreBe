package praca.inzynierska.goExplore.repositories;

import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import praca.inzynierska.goExplore.models.Location;

import java.util.Optional;


public interface LocationRepository extends MongoRepository<Location, String> {
        Optional<Location> findById(String id);
        }
