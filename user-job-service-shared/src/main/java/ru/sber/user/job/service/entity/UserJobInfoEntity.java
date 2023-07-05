package ru.sber.user.job.service.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "user_job_info")
@Entity
@Getter
@Setter
public class UserJobInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private CompanyEntity company;

    @ManyToOne
    private UsersEntity users;

    @Column(name = "description")
    private String description;

    @Column(name = "is_activity")
    private boolean isActivity;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJobInfoEntity that = (UserJobInfoEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserJobInfoEntity{" +
                "id=" + id +
                ", company=" + company +
                ", users=" + users +
                ", description='" + description + '\'' +
                ", isActivity=" + isActivity +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
