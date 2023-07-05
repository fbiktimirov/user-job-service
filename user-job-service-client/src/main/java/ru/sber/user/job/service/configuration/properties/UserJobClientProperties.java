package ru.sber.user.job.service.configuration.properties;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "client.user-job")
public class UserJobClientProperties {
    private final String url;
}
