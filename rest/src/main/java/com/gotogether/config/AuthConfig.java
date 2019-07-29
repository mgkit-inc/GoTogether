package com.gotogether.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean(name = "accessKey")
    public String getAccessKey() {
        return System.getProperty("server.access.key");
    }
    @Bean(name = "refreshKey")
    public String getRefreshKey() {
        return System.getProperty("server.refresh.key");
    }

}