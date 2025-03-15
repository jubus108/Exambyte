package de.propra.exambyte;

import de.propra.exambyte.web.TestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Testseite ist unter /home/test erreichbar")
    void test_testView1() throws Exception {
        mvc.perform(get("/home/test"))
                .andExpect(status().isOk());
    }
}
