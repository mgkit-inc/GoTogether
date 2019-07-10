package gotogether;

import com.gotogether.app.Profiles;
import gotogether.config.MainTestConfig;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainTestConfig.class})
public abstract class BaseTest {

    @BeforeClass
    public static void setSystemProperty() {
        System.getProperties().setProperty("spring.profiles.active", Profiles.TEST);
    }

}
