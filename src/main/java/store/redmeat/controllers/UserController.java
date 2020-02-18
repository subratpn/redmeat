package store.redmeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import store.redmeat.models.User;
import store.redmeat.repositories.UserRepository;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("user/{mobile}")
    public User findUser(@PathVariable String mobile){
        return userRepository.findByMobile(mobile);
    }
}
