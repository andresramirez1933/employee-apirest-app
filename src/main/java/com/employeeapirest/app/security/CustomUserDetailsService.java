package com.employeeapirest.app.security;

import com.employeeapirest.app.entity.Role;
import com.employeeapirest.app.entity.User;
import com.employeeapirest.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
