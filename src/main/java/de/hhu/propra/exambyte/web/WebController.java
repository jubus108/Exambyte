package de.hhu.propra.exambyte.web;

import de.hhu.propra.exambyte.config.AdminOnly;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String indexPrivate(@AuthenticationPrincipal OAuth2User principal, Model model) {
        String login = principal.getAttribute("login");
        model.addAttribute("name", login);
        return "dashboard";
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
