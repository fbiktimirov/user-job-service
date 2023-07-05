package ru.sber.user.job.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "company")
@Entity
@Getter
@Setter
public class CompanyEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "description")
    private String description;
    @Column(name = "created")
    private String created;
    @Column(name = "updated")
    private String updated;
    @Column(name = "is_activity")
    private boolean isActivity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity companyEntity = (CompanyEntity) o;
        return id.equals(companyEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", isActivity=" + isActivity +
                '}';
    }
}
