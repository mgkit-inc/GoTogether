package gotogether.config;

import com.gotogether.app.Profiles;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;

@Profile(value = Profiles.TEST)
@Configuration
@TestPropertySource(locations = "classpath:repos-test.properties")
public class H2TestConfig {
}
