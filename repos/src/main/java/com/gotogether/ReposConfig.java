package com.gotogether;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource(value = "repos.properties")
@EnableJpaRepositories(basePackages = {"com.gotogether.repos"})
public class ReposConfig {

}
