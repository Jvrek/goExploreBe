package praca.inzynierska.goExplore.locationModule.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import praca.inzynierska.goExplore.locationModule.models.LocationPopularity;


public interface PopularityRepository extends MongoRepository<LocationPopularity, String> {

}
