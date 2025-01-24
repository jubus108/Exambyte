package de.propra.exambyte.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class WebController {

    // GET-Mapping für die Startseite
    @GetMapping("/")
    public String index() {
        return "index"; // Verweist auf die Thymeleaf-Template-Datei "index.html"
    }

    // POST-Mapping für die Login-Verarbeitung
    @PostMapping("/")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        // Dummy-Validierung (nur zur Demonstration)
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("message", "Willkommen, " + username + "!");
            return "home"; // Weiterleitung zur Seite "home.html"
        } else {
            model.addAttribute("error", "Ungültige Anmeldedaten");
            return "index";
        }
    }
}
