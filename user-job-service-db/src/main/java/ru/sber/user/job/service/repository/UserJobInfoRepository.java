package ru.sber.user.job.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sber.user.job.service.entity.UserJobInfoEntity;

import java.util.Optional;

@Repository
public interface UserJobInfoRepository extends JpaRepository<UserJobInfoEntity, Integer> {

    @Query(value = "SELECT userInfo FROM UserJobInfoEntity userInfo " +
            " JOIN userInfo.users " +
            " WHERE userInfo.users.id = :userId " +
            " AND userInfo.isActivity = true ")
    Optional<UserJobInfoEntity> findByUserId(Integer userId);

    @Query(value = " SELECT userInfo FROM UserJobInfoEntity userInfo " +
            " JOIN userInfo.company " +
            " WHERE userInfo.company.id = :companyId " +
            " AND userInfo.isActivity = true ")
    Optional<UserJobInfoEntity> findByCompanyId(Integer companyId);
}
