package com.example.devsecops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        // Démonstration : Utilisation d'une entrée utilisateur directe
        // Dans un cas réel, cela pourrait mener à des vulnérabilités XSS ou Log4Shell
        return "Hello, " + name + "!";
    }

    @GetMapping("/admin/secrets")
    public String getSecrets() {
        // Simulation d'un endpoint critique
        return "Clé secrète Azure : AZURE_STUDENT_KEY_12345 (Ne jamais faire ça !)";
    }
}
