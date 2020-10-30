package com.example.miniproject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;

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

    @JsonProperty("gender")
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("aadhar_numer")
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

    @JsonProperty("active")
    private boolean active=true;
}