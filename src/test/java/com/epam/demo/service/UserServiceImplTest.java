package com.epam.demo.service;

import com.epam.demo.controller.dto.UserDto;
import com.epam.demo.service.impl.UserServiceImpl;
import com.epam.demo.service.model.User;
import com.epam.demo.service.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private final static String MOCK_EMAIL = "EMAIL";

    @Test
    void getUserByEmailTest() {
        //given
        User expectedUser = User.builder().email(MOCK_EMAIL).build();
        when(userRepository.getUser(MOCK_EMAIL)).thenReturn(expectedUser);

        //when
        UserDto actualUser = userService.getUser(MOCK_EMAIL);

        //then
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    void deleteUserTest() {
        //given
        doNothing().when(userRepository).deleteUser(MOCK_EMAIL);

        //when
        userService.deleteUser(MOCK_EMAIL);

        //then
        verify(userRepository, times(1)).deleteUser(MOCK_EMAIL);
    }

    @Test
    void deleteUserWithExceptionTest() {
        doThrow(RuntimeException.class).when(userRepository).deleteUser(any());

        assertThrows(RuntimeException.class,
                () -> userService.deleteUser(MOCK_EMAIL));
    }

    @Test
    public void updateUserTest() {
        //given
        when(userRepository.listUsers()).thenReturn(Collections.singletonList(User.builder().build()));

        //when
        List<UserDto> users = userService.listUsers();

        //then
        assertThat(users, hasSize(1));
    }
}
