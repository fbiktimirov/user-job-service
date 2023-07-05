package ru.sber.user.job.service.service;

import ru.sber.user.job.service.dto.UserJobInfoDto;

import java.util.List;

public interface UserJobService {
    void createUserJob(UserJobInfoDto userJobInfoDto);
    List<String> updateUserJob(UserJobInfoDto userJobInfoDto);
    UserJobInfoDto getUserJob(Integer userId, Integer companyId);
}
