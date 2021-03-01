package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MusicDbApplicationInit implements CommandLineRunner {
    private final UserService userService;

    public MusicDbApplicationInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initUsers();

    }
}
