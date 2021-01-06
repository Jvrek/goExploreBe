package praca.inzynierska.goExplore.loginModule.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import praca.inzynierska.goExplore.loginModule.models.ERole;
import praca.inzynierska.goExplore.loginModule.models.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}