package ru.sber.user.job.service.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ru.sber.user.job.service.configuration.properties.UserJobClientProperties;
import ru.sber.user.job.service.service.UserJobClient;

@EnableConfigurationProperties(UserJobClientProperties.class)
@EnableFeignClients(clients = UserJobClient.class)
@Configuration
public class UserJobClientAutoConfiguration {

}