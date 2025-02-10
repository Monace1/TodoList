package com.todolist.list.controller;

import com.todolist.list.model.User;
import com.todolist.list.config.SecurityConfig;
import com.todolist.list.repository.UserRepository;
import com.todolist.list.security.JwtUtil;
import com.todolist.list.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        //   try {
        //     Authentication authentication;
        //   authentication = authenticationManager.authenticate(
        //         new UsernamePasswordAuthenticationToken(
        //               credentials.get("username"),
        //             credentials.get("password")
        //   )
        //   );
        // if (authentication.isAuthenticated()) {
        //   UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // String token = jwtUtil.generateToken(userDetails.getUsername());
        // return ResponseEntity.ok(token);
        //} else {
        //   return ResponseEntity.status(401).body("Invalid credentials");
        //}
        // } catch (Exception e) {
        //   return ResponseEntity.status(401).body("Invalid credentials");
        //}
    //}
        return ResponseEntity.ok(authService.login(user));
}
}