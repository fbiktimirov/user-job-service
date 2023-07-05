package ru.sber.user.job.service.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sber.user.job.service.dto.UserJobInfoDto;
import ru.sber.user.job.service.entity.CompanyEntity;
import ru.sber.user.job.service.entity.UserJobInfoEntity;
import ru.sber.user.job.service.entity.UsersEntity;
import ru.sber.user.job.service.exception.DataAlreadyExistException;
import ru.sber.user.job.service.exception.RequestIncorrectException;
import ru.sber.user.job.service.exception.DataNotFoundException;
import ru.sber.user.job.service.mapper.UserJobInfoMapper;
import ru.sber.user.job.service.repository.CompanyRepository;
import ru.sber.user.job.service.repository.UserJobInfoRepository;
import ru.sber.user.job.service.repository.UserRepository;
import ru.sber.user.job.service.service.UserJobService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserJobServiceImpl implements UserJobService {

    private final UserJobInfoRepository userJobInfoRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final UserJobInfoMapper userJobInfoMapper;

    @Override
    public void createUserJob(UserJobInfoDto userJobInfoDto) {
        validate(userJobInfoDto);
        UserJobInfoEntity userJobInfoEntity = userJobInfoMapper.dtoToEntity(userJobInfoDto);
        UsersEntity savedUser = userRepository.save(userJobInfoDto.getUsers());
        CompanyEntity savedCompany = companyRepository.save(userJobInfoDto.getCompany());
        userJobInfoEntity.setUsers(savedUser);
        userJobInfoEntity.setCompany(savedCompany);
        userJobInfoEntity.setCreated(LocalDateTime.now());
        UserJobInfoEntity saved = userJobInfoRepository.save(userJobInfoEntity);
        log.info("Created UserJobInfoEntity {}", saved);
    }

    private void validate(UserJobInfoDto userJobInfoDto) {
        Integer companyId = userJobInfoDto.getCompany().getId();
        if (companyId != null && companyRepository.existsById(companyId)) {
            throw new DataAlreadyExistException("Company with ID " + companyId + " already exists.");
        }
        Integer userId = userJobInfoDto.getUsers().getId();
        if (userId != null && userRepository.existsById(userId)) {
            throw new DataAlreadyExistException("User with ID " + userId + " already exists.");
        }
    }

    @Override
    public List<String> updateUserJob(UserJobInfoDto userJobInfoDto) {
        UserJobInfoEntity userJobInfoEntity = userJobInfoRepository.findById(userJobInfoDto.getId()).orElseThrow(DataNotFoundException::new);
        List<String> updatedFields = new ArrayList<>();
        if (userJobInfoDto.getIsActivity() != null) {
            userJobInfoEntity.setActivity(userJobInfoDto.getIsActivity());
            updatedFields.add("is_activity");
        }
        if (userJobInfoDto.getDescription() != null) {
            userJobInfoEntity.setDescription(userJobInfoDto.getDescription());
            updatedFields.add("description");
        }
        userJobInfoEntity.setUpdated(LocalDateTime.now());
        UserJobInfoEntity updated = userJobInfoRepository.save(userJobInfoEntity);
        log.info("Updated UserJobInfoEntity {}", updated);
        return updatedFields;
    }

    @Override
    public UserJobInfoDto getUserJob(Integer userId, Integer companyId) {
        if (Objects.isNull(userId) && Objects.isNull(companyId)) {
            throw new RequestIncorrectException();
        }
        UserJobInfoEntity userJobInfoFromDB;
        if (Objects.nonNull(userId)) {
            userJobInfoFromDB = userJobInfoRepository.findByUserId(userId)
                    .orElseThrow(DataNotFoundException::new);
        } else {
            userJobInfoFromDB = userJobInfoRepository.findByCompanyId(companyId)
                    .orElseThrow(DataNotFoundException::new);
        }
        log.info("Found UserJobInfoEntity: {}", userJobInfoFromDB);
        return userJobInfoMapper.entityToDto(userJobInfoFromDB);
    }
}
