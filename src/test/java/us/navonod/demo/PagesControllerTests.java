package us.navonod.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagesControllerTests {
    PagesController hello;

    @BeforeEach
    public void setHelloGet() {
        hello = new PagesController();
    }
    @Test
    public void testReturnsPi() {
        this.mvc.perform(get("/math/pi"))
            .andExpect();
    }
}
