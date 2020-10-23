package com.example.miniproject.models.dto;

import lombok.*;

import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int user_id;
    private String firstName;
    private String lastName;
    //@Pattern @JsonProperty @JsonInclude @NotNull
    private String email;
    private String password;
    private String phone;

    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
