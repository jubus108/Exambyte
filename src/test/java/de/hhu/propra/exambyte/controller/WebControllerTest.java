package de.hhu.propra.exambyte.controller;

import de.hhu.propra.exambyte.config.MethodSecurityConfiguration;
import de.hhu.propra.exambyte.helper.WithMockOAuth2User;
import de.hhu.propra.exambyte.web.WebController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WebController.class)
@Import(MethodSecurityConfiguration.class)
public class WebControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Loginseite ist unter /login erreichbar")
    void test_login1() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockOAuth2User(login="something")
    @DisplayName("/login ist öffentlich zugänglich")
    void test_login2() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

//    @Test
//    @WithMockOAuth2User(login="something", roles = {"USER", "ADMIN"})
//    @DisplayName("Authentifizierte Nutzer:in wird automatisch von / nach /dashboard weitergeleitet")
//    void test_auth1() throws Exception {
//        mvc.perform(get("/"))
//                .andExpect(status().isOk());
//        //.andExpect(model().attribute("name", "something");
//    }

    @Test
    @WithMockOAuth2User(login="something")
    @DisplayName("/dashboard ist nur für authentifizierte Nutzer erreichbar")
    void test_auth2() throws Exception {
        mvc.perform(get("/dashboard"))
                .andExpect(status().isOk());
                //.andExpect(model().attribute("name", "something");
    }

    @Test
    @DisplayName("/admin ist für nicht-Admins nicht erreichbar")
    @WithMockOAuth2User(login="something", roles = {"USER"})
    void test_admin1() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isForbidden());
                //.andExpect(model().attribute("name", "something");
    }

    @Test
    @DisplayName("/admin ist für Admins erreichbar")
    @WithMockOAuth2User(login="something", roles = {"USER", "ADMIN"})
    void test_admin2() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isOk());
                //.andExpect(model().attribute("name", "something");
    }

}
