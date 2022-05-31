package com.employeeapirest.app.controller;

import com.employeeapirest.app.entity.Role;
import com.employeeapirest.app.entity.User;
import com.employeeapirest.app.payload.EmployeeDTO;
import com.employeeapirest.app.payload.JwtAuthResponseDTO;
import com.employeeapirest.app.payload.LogInDTO;
import com.employeeapirest.app.payload.SignUPDTO;
import com.employeeapirest.app.repository.RoleRepository;
import com.employeeapirest.app.repository.UserRepository;
import com.employeeapirest.app.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUPDTO signUPDTO){

        if(userRepository.existsByUsername(signUPDTO.getUsername())){
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUPDTO.getEmail())){
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();

        user.setUsername(signUPDTO.getUsername());
        user.setEmail(signUPDTO.getEmail());
        user.setName(signUPDTO.getName());
        user.setPassword(passwordEncoder.encode(signUPDTO.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN").get();

        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return new ResponseEntity<>("User created", HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDTO> logIn(@Valid @RequestBody LogInDTO logInDTO){


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInDTO.getUsernameOrEmail(), logInDTO.getPassword()));



        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return new ResponseEntity<>(new JwtAuthResponseDTO(token), HttpStatus.CREATED);

    }


}
