package ru.sber.user.job.service.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.sber.user.job.service.client.UserJobFeign;
import ru.sber.user.job.service.dto.UserJobInfoDto;
import ru.sber.user.job.service.exception.DataAlreadyExistException;
import ru.sber.user.job.service.exception.DataNotFoundException;
import ru.sber.user.job.service.exception.RequestIncorrectException;

@Slf4j
@RequiredArgsConstructor
public class UserJobClient {

    private final UserJobFeign userJobFeign;

    public void createUserJob(UserJobInfoDto userJobInfoDto) {
        try {
            userJobFeign.createUserJob(userJobInfoDto);
        } catch (FeignException e) {
            if (e.status() == 409) {
                throw new DataAlreadyExistException("Данные уже существуют");
            } else {
                throw e;
            }
        }
    }

    public void updateUserJob(UserJobInfoDto userJobInfoDto) {
        try {
            userJobFeign.updateUserJob(userJobInfoDto);
        } catch (FeignException e) {
            if (e.status() == 400) {
                throw new RequestIncorrectException("Изменяемый объект отсутствует");
            } else {
                throw e;
            }
        }
    }

    public UserJobInfoDto getUserJob(Integer userId, Integer companyId) {
        try {
            return userJobFeign.getUserJob(userId, companyId);
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new DataNotFoundException("Данные не найдены");
            } else {
                throw e;
            }
        }
    }
}
