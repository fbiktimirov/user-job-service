package ru.sber.user.job.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.user.job.service.dto.UserJobInfoDto;

import java.util.List;

@FeignClient(name = "userJobFeign", url = "${client.user-job.url}")
public interface UserJobFeign {
    @PostMapping("/create-userjob")
    ResponseEntity<?> createUserJob(@RequestBody UserJobInfoDto userJobInfoDto);

    @PatchMapping("/update-userjob")
    List<String> updateUserJob(@RequestBody UserJobInfoDto userJobInfoDto);

    @GetMapping("/get-userjob")
    UserJobInfoDto getUserJob(@RequestParam Integer userId, Integer companyId);
}
