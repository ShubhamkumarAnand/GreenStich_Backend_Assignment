package auth.backend.greenstitch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class resourceController {
    @GetMapping("/hello")
    public String getWelcomeMessage(){
        return "Hello, From GreenSwitch";
    }
}
