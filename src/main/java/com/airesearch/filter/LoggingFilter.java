package com.airesearch.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(LoggingFilter.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info(() -> "Request received from " + request.getRemoteAddr());
        chain.doFilter(request, response);
    }
}
