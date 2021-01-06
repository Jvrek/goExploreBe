package praca.inzynierska.goExplore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import praca.inzynierska.goExplore.models.User;
import praca.inzynierska.goExplore.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User getUserByName(String name){
        return repository.findByName(name);
    }

    public void saveUser(User user){
         repository.save(user);
    }
}
