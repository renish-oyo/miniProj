package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserResponseDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("aadhar_number")
    private String aadharNumber;

    @JsonProperty("pan_number")
    private String panNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_account_number")
    private String bankAccountNumber;

    @JsonProperty("bank_ifsc_code")
    private String banKIfscCode;

    @JsonProperty(value = "active")
    private boolean active;

}
