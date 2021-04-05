package com.example.demo.User.config;

import com.example.demo.User.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                // 配置所有的请求，包括静态资源
                .addPathPatterns("/**")
                // 放行的请求
                .excludePathPatterns("/user/**");
    }
}
