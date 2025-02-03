package com.assessment.maybank.springboot_api.middleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("Interceptor triggered for");
        logger.info("Incoming Request: [{}] {} at {}", request.getMethod(), request.getRequestURI(), LocalDateTime.now());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("Outgoing Response: [{}] {} - Status: {} at {}", request.getMethod(), request.getRequestURI(), response.getStatus(), LocalDateTime.now());

        if (ex != null) {
            logger.error("Exception occurred: ", ex);
        }
    }
}