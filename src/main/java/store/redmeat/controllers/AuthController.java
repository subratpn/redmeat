package store.redmeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.redmeat.components.JwtTokenProvider;
import store.redmeat.exceptions.InvalidCredentialsException;
import store.redmeat.exceptions.UserExistsException;
import store.redmeat.models.User;
import store.redmeat.repositories.UserRepository;
import store.redmeat.services.CustomUserDetailsService;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @Autowired
    private CustomUserDetailsService userService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User data) {
        try {
            String mobile = data.getMobile();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mobile, data.getPassword()));
            String token = jwtTokenProvider.createToken(mobile, this.users.findByMobile(mobile).getRoles());
            Map<Object, Object> model = new HashMap<>();
            model.put("mobile", mobile);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid mobile/password supplied");
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        User userExists = userService.findUserByMobile(user.getMobile());
        if (userExists != null) {
            throw new UserExistsException("User with Mobile : " + user.getMobile() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
}
