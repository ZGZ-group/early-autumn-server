package com.zgz.group.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("/login");
//        registry.addViewController("/index").setViewName("/login");
//        registry.addViewController("/index.html").setViewName("/login");
//        registry.addViewController("/login.html").setViewName("/login");
    }
}
