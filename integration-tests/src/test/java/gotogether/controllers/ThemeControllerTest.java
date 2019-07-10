package gotogether.controllers;

import gotogether.BaseControllerTest;
import com.gotogether.entity.Theme;
import com.gotogether.json.JsonUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThemeControllerTest extends BaseControllerTest {

    @Test
    public void testAdding() throws Exception {
        List<Theme> theme = Collections.singletonList(
                new Theme("theme1")
        );

        List<Theme> themeList = Arrays.asList(
                new Theme("theme 2"),
                new Theme("theme 3"),
                new Theme("theme 4")
        );

        byte[] themeJson = JsonUtil.toByteJSON(theme);
        byte[] themeListJson = JsonUtil.toByteJSON(themeList);
        testResponse(HttpMethod.POST, "/themes/", "$[0].title", "theme1", themeJson);
        testResponse(HttpMethod.POST, "/themes/", "$[2].title", "theme 4", themeListJson);
        testResponse(HttpMethod.GET, "/themes/", "$[0].title", "theme1");
        testResponse(HttpMethod.GET, "/themes/", "$[1].title", "theme 2");
        testResponse(HttpMethod.GET, "/themes/", "$[2].title", "theme 3");
        testResponse(HttpMethod.GET, "/themes/", "$[3].title", "theme 4");
    }


}
