package de.hhu.propra.exambyte.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutor")
public class KorrektorInController {

    @GetMapping("/")
    @Secured("ROLE_TUTOR")
    public String admin(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("user",
                principal != null ? principal.getAttribute("login") : null
        );
        return "tutor";
    }
}
