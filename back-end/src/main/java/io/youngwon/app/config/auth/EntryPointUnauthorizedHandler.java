package io.youngwon.app.config.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    static String _401 = "{\"success\":false,\"response\":null,\"error\":{\"message\":\"Unauthorized\",\"status\":401}}";

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setHeader("content-type", "application/json");
        httpServletResponse.getWriter().write(_401);
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }
}
