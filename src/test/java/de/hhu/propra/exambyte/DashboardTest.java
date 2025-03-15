package de.hhu.propra.exambyte;

import de.hhu.propra.exambyte.web.DashboardController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DashboardController.class)
public class DashboardTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Startseite ist unter /home erreichbar")
    void test_dashboard1() throws Exception {
        mvc.perform(get("/home"))
                .andExpect(status().isOk());
    }
}
