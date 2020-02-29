package store.redmeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import store.redmeat.models.User;
import store.redmeat.repositories.UserRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("user/mobile")
    public User findUserByMobile(@RequestParam("id") String mobile) {
        return userRepository.findByMobile(mobile);
    }



}
