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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int userId;

    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonProperty("gender")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gender;

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonProperty("aadhar_numer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String aadharNumber;

    @JsonProperty("pan_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String panNumber;

    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;

    @JsonProperty("bank_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bankName;

    @JsonProperty("bank_account_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bankAccountNumber;

    @JsonProperty("bank_ifsc_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String banKIfscCode;

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean active=true;

    public UserRequestDTO(int userId,String email, String password) {
        this.userId=userId;
        this.email=email;
        this.password=password;
    }


}