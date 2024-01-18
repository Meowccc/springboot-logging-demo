package com.example.demo.config;

import com.example.demo.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author meow
 */
@Configuration
public class LoggingConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilterRegistration() {
        FilterRegistrationBean<LoggingFilter> registration = new FilterRegistrationBean<>();
        LoggingFilter loggingFilter = new LoggingFilter();
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeQueryString(true);
        registration.setFilter(loggingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("loggingFilter");
        return registration;
    }
}
