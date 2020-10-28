package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    //@Pattern(message = "Email is invalid", regexp = "^.+@.+\\..+$")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("role_id")
    private int roleId;

    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
