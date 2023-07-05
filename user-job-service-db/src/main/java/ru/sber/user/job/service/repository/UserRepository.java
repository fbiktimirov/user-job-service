package ru.sber.user.job.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sber.user.job.service.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
}
