package com.epam.demo.controller;

import com.epam.demo.controller.dto.UserDto;
import com.epam.demo.service.UserService;
import com.epam.demo.test.config.TestWebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(value = UserController.class)
@AutoConfigureMockMvc
@Import(TestWebConfig.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUsersTest() throws Exception {
        UserDto userDto = UserDto
                .builder()
                .firstName("TESTNAME")
                .build();

        when(userService.listUsers()).thenReturn(Collections.singletonList(userDto));

        mockMvc.perform(get("/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName").value(userDto.getFirstName()));
    }

    @Test
    void getAllUsers_expectException_onError() throws Exception {
        String message = "error message";
        when(userService.listUsers()).thenThrow(new NullPointerException(message));

        mockMvc.perform(get("/user"))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(content().string(message));
    }
}
