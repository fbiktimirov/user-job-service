package ru.sber.user.job.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJobController {

    @PostMapping("/create-userjob")
    public void createUserJob() {

    }

    @PatchMapping("/update-userjob")
    public void updateUserJob() {

    }

    @GetMapping("/get-userjob")
    public void getUserJob() {

    }
}
