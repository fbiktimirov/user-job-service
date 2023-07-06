package ru.sber.user.job.service.service;

import feign.FeignException;
import feign.Request;
import feign.RequestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.sber.user.job.service.client.UserJobFeign;
import ru.sber.user.job.service.dto.UserJobInfoDto;
import ru.sber.user.job.service.exception.DataAlreadyExistException;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class UserJobClientTest {

    @Mock
    private UserJobFeign userJobFeign;

    private UserJobClient userJobClient;

    private UserJobInfoDto userJobInfoDto;

    @BeforeEach
    void setUp() {
        userJobClient = new UserJobClient(userJobFeign);
        userJobInfoDto = new UserJobInfoDto();
    }

    @Test
    void whenCreateUserJob_correctParam_success() {
        Mockito.when(userJobFeign.createUserJob(userJobInfoDto)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());

        userJobClient.createUserJob(userJobInfoDto);

        Mockito.verify(userJobFeign, Mockito.times(1)).createUserJob(userJobInfoDto);
    }

    @Test
    void whenUpdateUserJob_correctParam_success() {
        Mockito.when(userJobFeign.updateUserJob(userJobInfoDto)).thenReturn(Collections.emptyList());

        userJobClient.updateUserJob(userJobInfoDto);

        Mockito.verify(userJobFeign, Mockito.times(1)).updateUserJob(userJobInfoDto);
    }

    @Test
    void whenGetUserJob_correctParam_success() {
        Mockito.when(userJobFeign.getUserJob(anyInt(), anyInt())).thenReturn(userJobInfoDto);

        UserJobInfoDto result = userJobClient.getUserJob(1, 1);

        assertEquals(userJobInfoDto, result);
        Mockito.verify(userJobFeign, Mockito.times(1)).getUserJob(1, 1);
    }

    @Test
    void whenCreateUserJob_userJobAlreadyExist_throwException() {
        Mockito.when(userJobFeign.createUserJob(userJobInfoDto))
                .thenThrow(buildConflictException());

        assertThrows(DataAlreadyExistException.class, () -> userJobClient.createUserJob(userJobInfoDto));

        Mockito.verify(userJobFeign, Mockito.times(1)).createUserJob(userJobInfoDto);
    }

    private FeignException.Conflict buildConflictException() {
        Request request = Request.create(Request.HttpMethod.GET, "/", new HashMap<>(), null, Charset.defaultCharset(), RequestTemplate.from(new RequestTemplate()));
        return new FeignException.Conflict("409 Conflict", request, "Данные уже существуют".getBytes(), new HashMap<>());
    }
}