package com.prits.preauth.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3ppat on 1/8/2017.
 */
public class CustomUserDetailsService implements UserDetailsService {


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username recieved :: " + username);
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("ROLE_USER");
        authorityList.add(userRole);
        UserDetails user = new User(username, "", true, true, true, true,authorityList );
        return user;
    }
}
