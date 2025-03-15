package de.propra.exambyte.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home/test")
public class TestController {

    @GetMapping("")
    public String test() {
        return "testView";
    }
}
