package controllers;

import models.User;
import org.springframework.web.client.RestTemplate;

public class UserController {
    private RestTemplate restTemplate;

    public UserController() {
        restTemplate = new RestTemplate();
    }

    private final String API_BASE = "https://api.github.com";

    public User getUserByUsername(String username) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + username, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public User[] getFollowersByUser(String username) {
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + username + "/followers", User[].class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
