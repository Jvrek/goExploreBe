package praca.inzynierska.goExplore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import praca.inzynierska.goExplore.models.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByName(String name);

}
