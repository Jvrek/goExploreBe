package praca.inzynierska.goExplore.locationModule.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import praca.inzynierska.goExplore.locationModule.models.Location;

import java.util.Optional;


public interface LocationRepository extends MongoRepository<Location, String> {
        Optional<Location> findById(String id);
        }
