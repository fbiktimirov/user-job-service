package ru.sber.user.job.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.sber.user.job.service.dto.UserJobInfoDto;
import ru.sber.user.job.service.exception.DataNotFoundException;
import ru.sber.user.job.service.service.UserJobService;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserJobInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserJobService userJobService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenCreateUserJob_withCorrectParams_thenResponseStatusCreated() throws Exception {
        UserJobInfoDto userJobInfoDto = new UserJobInfoDto();
        // Инициализация userJobInfoDto

        doNothing().when(userJobService).createUserJob(any(UserJobInfoDto.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/create-userjob")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userJobInfoDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(userJobService, times(1)).createUserJob(any(UserJobInfoDto.class));
    }

    @Test
    public void whenUpdateUserJob_withCorrectParams_thenResponseStatusOk() throws Exception {
        UserJobInfoDto userJobInfoDto = new UserJobInfoDto();
        // Инициализация userJobInfoDto

        when(userJobService.updateUserJob(any(UserJobInfoDto.class))).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.patch("/update-userjob")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userJobInfoDto)))
                .andExpect(status().isOk());

        verify(userJobService, times(1)).updateUserJob(any(UserJobInfoDto.class));
    }

    @Test
    public void whenGetUserJob_withCorrectParams_thenResponseStatusOk() throws Exception {
        UserJobInfoDto userJobInfoDto = new UserJobInfoDto();
        // Инициализация userJobInfoDto

        when(userJobService.getUserJob(anyInt(), anyInt())).thenReturn(userJobInfoDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/get-userjob")
                        .param("userId", "1")
                        .param("companyId", "1"))
                .andExpect(status().isOk());

        verify(userJobService, times(1)).getUserJob(anyInt(), anyInt());
    }

    @Test
    public void whenGetUserJob_parameterNotExisting_thenResponseStatusNotFound() throws Exception {
        when(userJobService.getUserJob(anyInt(), anyInt())).thenThrow(new DataNotFoundException());

        mockMvc.perform(get("/get-userjob")
                        .param("userId", "1")
                        .param("companyId", "1"))
                .andExpect(status().isNotFound());

        verify(userJobService, times(1)).getUserJob(anyInt(), anyInt());
    }
}