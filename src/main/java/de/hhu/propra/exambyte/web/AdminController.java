package de.hhu.propra.exambyte.web;

import de.hhu.propra.exambyte.application.services.ExamByteService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ExamByteService service;

    public AdminController(ExamByteService service) {
        this.service = service;
    }

    @GetMapping("")
    @Secured("ROLE_ADMIN")
    public String admin(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("user",
                principal != null ? principal.getAttribute("login") : null
        );
        return "admin";
    }
}
