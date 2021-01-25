package praca.inzynierska.goExplore.userModule.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import praca.inzynierska.goExplore.userModule.models.User;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String id);
}
