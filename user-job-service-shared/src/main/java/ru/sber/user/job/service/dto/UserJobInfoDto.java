package ru.sber.user.job.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sber.user.job.service.entity.CompanyEntity;
import ru.sber.user.job.service.entity.UsersEntity;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserJobInfoDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("company")
    private CompanyEntity company;

    @JsonProperty("users")
    private UsersEntity users;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isActivity")
    private Boolean isActivity;

    @JsonProperty("created")
    private LocalDateTime created;

    @JsonProperty("updated")
    private LocalDateTime updated;
}
