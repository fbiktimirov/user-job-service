package ru.sber.user.job.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserJobInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company")
    private CompanyEntity company;

    @Column(name = "users")
    private UsersEntity users;

    @Column(name = "description")
    private String description;

    @Column(name = "isActivity")
    private boolean isActivity;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}
