package praca.inzynierska.goExplore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import praca.inzynierska.goExplore.models.User;
import praca.inzynierska.goExplore.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User getUserByName(@RequestParam(name = "name") String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
         userService.saveUser(user);
    }

}
