package de.hhu.propra.exambyte;

import de.hhu.propra.exambyte.web.WebController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WebController.class)
public class WebControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Loginseite ist unter /login erreichbar")
    void test_login1() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

}
