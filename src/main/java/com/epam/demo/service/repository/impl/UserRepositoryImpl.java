package com.epam.demo.service.repository.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.demo.service.model.User;
import com.epam.demo.service.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

  private final List<User> list = new ArrayList<>();

  @Override
  public User getUser(String email) {
    return list.stream()
        .filter(user -> user.getEmail().equals(email))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("User is not found!"));
  }

  @Override
  public List<User> listUsers() {
    return new ArrayList<>(list);
  }

  @Override
  public User createUser(User user) {
    user.setWrittenOn(Instant.now());
    list.add(user);
    return user;
  }

  @Override
  public User updateUser(String email, User user) {
    boolean isDeleted = list.removeIf(u -> u.getEmail().equals(email));
    if (isDeleted) {
      list.add(user);
    } else {
      throw new RuntimeException("User is not found!");
    }
    return user;
  }

  @Override
  public void deleteUser(String email) {
    list.removeIf(user -> user.getEmail().equals(email));
  }

}
