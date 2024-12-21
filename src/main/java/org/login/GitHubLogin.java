package org.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@SpringBootApplication
@Controller
public class GitHubLogin {
    public static void main(String[] args) {
        SpringApplication.run(GitHubLogin.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, OAuth2AuthenticationToken authentication) {
        // Extract the OAuth2User from the authentication token
        OAuth2User oauthUser = authentication.getPrincipal();

        // Add attributes to the model
        model.addAttribute("name", oauthUser.getAttribute("name"));
        model.addAttribute("login", oauthUser.getAttribute("login"));
        model.addAttribute("avatar_url", oauthUser.getAttribute("avatar_url"));

        return "welcome"; // Renders src/main/resources/templates/welcome.html
    }
}