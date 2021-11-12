package com.epam.demo.service.model;

import lombok.*;

import java.time.Instant;

@Data
@Builder
public class User {

  private String firstName;
  private String lastName;
  private String email;
  private Instant writtenOn;

}