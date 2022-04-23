package com.skillsoft.springbootmail.config;

import com.skillsoft.springbootmail.interceptor.BookHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfiguration implements WebMvcConfigurer {
    @Autowired
    private BookHandlerInterceptor bookHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bookHandlerInterceptor);
    }
}
