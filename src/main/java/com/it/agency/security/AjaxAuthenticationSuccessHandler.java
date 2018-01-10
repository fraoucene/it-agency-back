package com.it.agency.security;

import com.it.agency.beans.User;
import com.it.agency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    HeaderHandler headerHandler;
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.debug("Authentication Successful");
        response.getWriter().print("{ \"token\" : \"" + "je_suis_le_token_de_test" + "\"}");
        response.setStatus(HttpServletResponse.SC_OK);
        headerHandler.process(request, response);
    }

}
