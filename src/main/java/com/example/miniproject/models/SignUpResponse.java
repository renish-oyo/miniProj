package com.example.miniproject.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpResponse {
    private int user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
