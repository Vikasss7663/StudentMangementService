package com.student.management.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Value("${authentication.password:123456}")
    private String password;

    @Value("${authentication.username:Vishal}")
    private String username;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(userName.equals(username)) {
            return new User(userName, password, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Provide Valid UserName");
        }
    }

}
