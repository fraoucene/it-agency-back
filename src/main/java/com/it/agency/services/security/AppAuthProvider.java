package com.it.agency.services.security;

import com.it.agency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    UserService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();


        UserDetails user = userDetailsService.loadUserByUsername(name);

        if (user == null || !user.getPassword().equals(password) || !user.getUsername().equals(name)) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name, password, user.getAuthorities());
        token.setDetails(user);
        return token;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return  true;

    }
}