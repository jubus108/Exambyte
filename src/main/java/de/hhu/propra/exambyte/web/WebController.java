package de.hhu.propra.exambyte.web;

import de.hhu.propra.exambyte.config.AdminOnly;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;
import java.util.Objects;


@Controller
@SessionScope
public class WebController {

    public WebController() {}

    @GetMapping("/")
    public String login(Model model, @AuthenticationPrincipal OAuth2User oAuth2User) {
        model.addAttribute("user", oAuth2User != null ? oAuth2User.getAttribute("login") : null);
        return oAuth2User != null ? "redirect:/dashboard" :  "login";
    }

    @GetMapping("/dashboard")
    public String dashboardPrivate(@AuthenticationPrincipal OAuth2User principal, Model model) {
        String login = principal.getAttribute("login");
        model.addAttribute("name", login);
        return "dashboard";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String admin(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("user",
                principal != null ? principal.getAttribute("login") : null
        );
        return "admin";
    }
}
