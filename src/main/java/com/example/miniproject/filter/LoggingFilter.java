package com.example.miniproject.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class LoggingFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long time = System.currentTimeMillis();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //Request Logger
        LOGGER.info("\nRequest Header :\n\nMethod: {}\nRequest URL: {}\nRequest URI: {}\nQuery String: {}\n",request.getMethod(),request.getRequestURL(),request.getRequestURI(),request.getQueryString());

        //Response Logger
        response.addDateHeader("Date",1000);
        response.addHeader("Custom Header","This is Custom Header.");
        LOGGER.info("\nResponse Header :\n\nStatus Code: {}\nContent-Type: {}\nLocale: {}\nDate: {}\nCustom Header: {}\n",response.getStatus(),response.getContentType(),response.getLocale(),response.getHeader("Date"),response.getHeader("Custom Header"));

        //Calling FilterChain
        filterChain.doFilter(servletRequest,servletResponse);

        //For Response Time
        time=System.currentTimeMillis() - time;
        LOGGER.info("\n\nResponse Time: {}ms\n",time);
    }
}
