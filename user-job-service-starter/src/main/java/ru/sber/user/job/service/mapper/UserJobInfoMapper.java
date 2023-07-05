package ru.sber.user.job.service.mapper;

import ru.sber.user.job.service.dto.UserJobInfoDto;
import ru.sber.user.job.service.entity.UserJobInfoEntity;

import java.time.LocalDateTime;

public class UserJobInfoMapper {
    public UserJobInfoEntity dtoToEntity(UserJobInfoDto userJobInfoDto) {
        UserJobInfoEntity userJobInfoEntity = new UserJobInfoEntity();
        userJobInfoEntity.setId(userJobInfoDto.getId());
        userJobInfoEntity.setUsers(userJobInfoDto.getUsers());
        userJobInfoEntity.setUpdated(LocalDateTime.now());
        userJobInfoEntity.setCreated(userJobInfoDto.getCreated());
        userJobInfoEntity.setActivity(userJobInfoDto.getIsActivity());
        userJobInfoEntity.setDescription(userJobInfoDto.getDescription());
        userJobInfoEntity.setCompany(userJobInfoDto.getCompany());
        return userJobInfoEntity;
    }

    public UserJobInfoDto entityToDto(UserJobInfoEntity userJobInfoEntity) {
        UserJobInfoDto userJobInfoDto = new UserJobInfoDto();
        userJobInfoDto.setId(userJobInfoEntity.getId());
        userJobInfoDto.setCompany(userJobInfoEntity.getCompany());
        userJobInfoDto.setUsers(userJobInfoEntity.getUsers());
        userJobInfoDto.setDescription(userJobInfoEntity.getDescription());
        userJobInfoDto.setIsActivity(userJobInfoEntity.isActivity());
        userJobInfoDto.setCreated(userJobInfoEntity.getCreated());
        userJobInfoDto.setUpdated(userJobInfoEntity.getUpdated());
        return userJobInfoDto;
    }
}
