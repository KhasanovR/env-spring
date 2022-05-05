package com.netlane.env;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arniu.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/env")
public class EnvController {

    private final Dotenv dotenv;

    public EnvController() {
        this.dotenv = Dotenv.configure().load();;
    }

    @GetMapping
    public Map<String, String> get_envs() {
        Map<String, String> envs = new HashMap<>();
        for (String key: dotenv.keys()) {
            envs.put(key, dotenv.get(key));
        }
        return envs;
    }
}
