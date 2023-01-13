package com.callcenter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersDetailsService implements UserDetailsService {

    private String Username;
    private String password;

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ArrayList<GrantedAuthority> roles = new ArrayList<>();

        if (username != null) {

            var user = userService.findUserById(username);


            if (user != null && user.isState() == true) {

                if (user.isState() != false) {

                    Username = user.getId().toString();
                    password = user.getPassword();

                    String rol;
                    if (user.isTypeUser() == true) {
                        rol = "ROLE_ADMIN";
                    } else {
                        rol = "ROLE_COLABORATOR";
                    }

                    roles.add(new SimpleGrantedAuthority(rol));
                }else{
                    throw new UsernameNotFoundException(username);
                }
            }
        }
        return new User(Username, password, roles);
    }
}