package praca.inzynierska.goExplore.loginModule.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import praca.inzynierska.goExplore.loginModule.models.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}