package ru.sber.user.job.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", isBlocked=" + isBlocked +
                '}';
    }
}

