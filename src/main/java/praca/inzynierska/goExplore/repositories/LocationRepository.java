package praca.inzynierska.goExplore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import praca.inzynierska.goExplore.models.Location;

import java.util.List;
import java.util.Optional;


public interface LocationRepository extends MongoRepository<Location, String> {
        Optional<Location> findById(String id);
        }
