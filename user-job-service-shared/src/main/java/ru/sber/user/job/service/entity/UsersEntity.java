package ru.sber.user.job.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "users")
@Entity
@Getter
@Setter
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity usersEntity = (UsersEntity) o;
        return id.equals(usersEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

