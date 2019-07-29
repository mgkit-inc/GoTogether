package gotogether;

import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;
import com.gotogether.json.JsonUtil;
import com.gotogether.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class AuthControllerTest extends BaseControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetTokens() throws Exception {
        User user1 = new User("user1", "email1@gmail.com", "pass1", true);

        userService.register(user1);

        byte[] userJson = JsonUtil.toByteJSON(user1);

        testResponse(HttpMethod.POST, "/auth", "$", HttpStatus.OK, userJson);
    }

}