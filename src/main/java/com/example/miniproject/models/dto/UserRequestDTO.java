package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("email")
    //@Pattern(message = "Email is invalid", regexp = "^.+@.+\\..+$")
    private String email;

    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonProperty("role_id")
    private int roleId;

}
