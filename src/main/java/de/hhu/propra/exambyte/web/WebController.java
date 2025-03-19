package de.hhu.propra.exambyte.web;

import de.hhu.propra.exambyte.application.services.ExamByteService;
import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class WebController {

    private final ExamByteService service;

    public WebController(ExamByteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String login(Model model, @AuthenticationPrincipal OAuth2User principal) {

        if (principal != null) {

            Integer githubId = principal.getAttribute("id"); //  GitHub-Id
            String username = principal.getAttribute("login"); // GitHub-Username

            model.addAttribute("user", service.nutzerInHinzufuegen(githubId, username));
            return redirectByRole(principal);
        } else {
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OAuth2User principal, Model model) {
        String login = principal.getAttribute("login");
        model.addAttribute("name", login);
        return "dashboard";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

    private String redirectByRole(@AuthenticationPrincipal OAuth2User principal) {
        // Retrieve the authorities (roles) from the OAuth2User
        var authorities = principal.getAuthorities();

        // Check for specific roles and redirect accordingly
        if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/";
        }
        else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_TUTOR"))) {
            return "redirect:/tutor/";
        }
        else {
            return "redirect:/dashboard";
        }
    }
}
