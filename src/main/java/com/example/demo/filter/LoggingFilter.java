package com.example.demo.filter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author meow
 */
@Slf4j
public class LoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected boolean shouldLog(@NonNull HttpServletRequest request) {
        return true;
    }

    @Override
    protected void beforeRequest(@NonNull HttpServletRequest request, @NonNull String message) {
        log.info(message);
    }

    @Override
    protected void afterRequest(@NonNull HttpServletRequest request, @NonNull String message) {
        log.info(message);
    }
}
