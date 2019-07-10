package gotogether.config;

import com.gotogether.Application;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Application.class, H2TestConfig.class})
public class MainTestConfig {
}
