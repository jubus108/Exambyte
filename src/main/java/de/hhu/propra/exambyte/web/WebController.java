package de.hhu.propra.exambyte.web;

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
        return "login"; // Verweist auf die Thymeleaf-Template-Datei "login.html"
    }

    @PostMapping("/login")
    public String loginVerarbeitung(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        // Dummy-Validierung (nur zur Demonstration)
        if (username.equals("user") && password.equals("password")) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Ungültige Anmeldedaten");
            return "redirect:/login";
        }
    }
}
