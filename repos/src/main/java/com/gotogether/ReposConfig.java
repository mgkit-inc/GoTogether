package com.gotogether;

import com.gotogether.app.Profiles;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile(value = {Profiles.PROD, Profiles.DEV})
@PropertySource(value = "/repos.properties")
@EnableJpaRepositories(basePackages = {"com.gotogether.repos"})
public class ReposConfig {

}
