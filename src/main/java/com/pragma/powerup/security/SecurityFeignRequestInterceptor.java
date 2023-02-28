package com.pragma.powerup.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SecurityFeignRequestInterceptor implements RequestInterceptor {

    private static final String AUTHENTICATION_HEADER = "Authorization";
    @Override
    public void apply(RequestTemplate template) {
       template.header(AUTHENTICATION_HEADER,getBearerTokenHeader());
    }

    public static String getBearerTokenHeader(){
        System.out.println(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"));
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }
}
