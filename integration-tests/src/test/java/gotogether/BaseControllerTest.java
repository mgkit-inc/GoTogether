package gotogether;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.function.Function;

@AutoConfigureMockMvc
public abstract class BaseControllerTest extends BaseTest {

    @Autowired
    protected MockMvc mockMvc;

    protected enum HttpMethod {
        GET(MockMvcRequestBuilders::get),
        POST(MockMvcRequestBuilders::post),
        PUT(MockMvcRequestBuilders::put),
        DELETE(MockMvcRequestBuilders::delete);

        private final Function<String, MockHttpServletRequestBuilder> method;

        HttpMethod(Function<String, MockHttpServletRequestBuilder> method) {
            this.method = method;
        }
    }

    protected static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    protected void testResponse(HttpMethod httpMethod,
                                String endpoint,
                                String jsonPath,
                                Object expectedValue) throws Exception {
        testResponse(httpMethod, endpoint, jsonPath, expectedValue, HttpStatus.OK, null);
    }

    protected void testResponse(HttpMethod httpMethod,
                                String endpoint,
                                String jsonPath,
                                Object expectedValue,
                                byte[] content) throws Exception {
        testResponse(httpMethod, endpoint, jsonPath, expectedValue, HttpStatus.OK, content);
    }

    protected void testResponse(HttpMethod httpMethod,
                                String endpoint,
                                String jsonPath,
                                Object expectedValue,
                                HttpStatus status,
                                byte[] content) throws Exception {
        mockMvc.perform(httpMethod.method.apply(endpoint).content(content).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(status.value()))
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath(jsonPath).value(expectedValue));
    }

}
