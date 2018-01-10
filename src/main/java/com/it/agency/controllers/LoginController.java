package com.it.agency.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    static final String USERNAME = "username";
    static final String AUTHORIZATIONS = "permissions";

    @RequestMapping(
            value = "success",
            method = RequestMethod.GET)
    public HttpEntity success(HttpServletResponse response) throws ServletException {


        Map<String,Object> result = new HashMap<>();
        Map<String, Boolean> authorizations = new HashMap();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            authorizations.put(grantedAuthority.getAuthority(), Boolean.TRUE);
        }
        result.put(AUTHORIZATIONS, authorizations);
        String username = (String) auth.getPrincipal();
        result.put(USERNAME, username);

        return new HttpEntity(result);
    }
}
