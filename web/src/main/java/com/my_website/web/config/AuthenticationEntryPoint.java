package com.my_website.web.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authentication)
            throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm - " + getRealmName() + "");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Http Status 401 " + authentication.getMessage());
        }
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("MyWebsite");
        super.afterPropertiesSet();
    }
}
