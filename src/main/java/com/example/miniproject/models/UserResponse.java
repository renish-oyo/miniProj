package com.example.miniproject.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
