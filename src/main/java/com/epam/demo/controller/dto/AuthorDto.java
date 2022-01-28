package com.epam.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class AuthorDto {

    @JsonProperty(access = READ_ONLY)
    public String id;

    @NotBlank
    @NotNull
    public String name;

    public String nickname;

}
