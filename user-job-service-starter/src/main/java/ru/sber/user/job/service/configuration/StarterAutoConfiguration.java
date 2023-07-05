package ru.sber.user.job.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sber.user.job.service.mapper.UserJobInfoMapper;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class StarterAutoConfiguration {

    @Bean
    public UserJobInfoMapper userJobInfoMapper() {
        return new UserJobInfoMapper();
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.sber.user.job.service.controller"))
                .build();
    }

}