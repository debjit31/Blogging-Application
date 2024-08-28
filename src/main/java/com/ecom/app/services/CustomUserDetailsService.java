package com.ecom.app.services;

import com.ecom.app.entity.User;
import com.ecom.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found!!!");

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));

    }
}
