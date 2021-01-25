package praca.inzynierska.goExplore.userModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import praca.inzynierska.goExplore.locationModule.models.Location;
import praca.inzynierska.goExplore.userModule.models.User;
import praca.inzynierska.goExplore.userModule.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<User> getAllLocation() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public Optional<User> getLocation(@PathVariable(value="id", required=true) String id){
        return this.userService.getUser(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable(value="id", required=true) String id, @RequestBody User user){
        this.userService.updateUser(user, id);
        return ResponseEntity.ok("Zaktualizowano pomyślnie");
    }
}
