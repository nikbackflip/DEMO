package com.epam.demo.service;


import com.epam.demo.controller.dto.UserDto;

import java.util.List;

public interface UserService {

  UserDto getUser(String email);

  List<UserDto> listUsers();

  UserDto createUser(UserDto userDto);

  UserDto updateUser(String email, UserDto userDto);

  void deleteUser(String email);

}