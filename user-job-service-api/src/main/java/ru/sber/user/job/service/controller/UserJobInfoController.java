package ru.sber.user.job.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.user.job.service.dto.UserJobInfoDto;
import ru.sber.user.job.service.service.UserJobService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserJobInfoController {

    private final UserJobService userJobService;

    @PostMapping("/create-userjob")
    public ResponseEntity<?> createUserJob(@RequestBody UserJobInfoDto userJobInfoDto) {
        userJobService.createUserJob(userJobInfoDto);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/update-userjob")
    public List<String> updateUserJob(@RequestBody UserJobInfoDto userJobInfoDto) {
        return userJobService.updateUserJob(userJobInfoDto);
    }

    @GetMapping("/get-userjob")
    public UserJobInfoDto getUserJob(@RequestParam Integer userId, Integer companyId) {
        return userJobService.getUserJob(userId, companyId);
    }
}
