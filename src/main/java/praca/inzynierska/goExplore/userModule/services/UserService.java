package praca.inzynierska.goExplore.userModule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praca.inzynierska.goExplore.loginModule.repository.UserRepository;
import praca.inzynierska.goExplore.userModule.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(String id){
        return this.userRepository.findById(id);
    }

    public void updateUser(User newUser, String id){
        Optional<User> user = this.userRepository.findById(id);
        user.ifPresent(usr -> {
            if(newUser.getUsername() != null){
                usr.setUsername(newUser.getUsername());
            }
            if(newUser.getEmail() != null){
                usr.setEmail(newUser.getEmail());
            }
            this.userRepository.save(usr);
        });
    }
}
