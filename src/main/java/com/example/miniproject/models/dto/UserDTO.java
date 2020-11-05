package com.example.miniproject.models.dto;

import com.example.miniproject.models.entity.Designation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

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

    @JsonIgnore
    @JsonProperty("password")
    private String  password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("aadhar_number")
    private String aadharNumber;

    @JsonProperty("pan_number")
    private String panNumber;

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value="state")
    private String state;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_account_number")
    private String bankAccountNumber;

    @JsonProperty("bank_ifsc_code")
    private String banKIfscCode;

    @JsonProperty("active")
    private boolean active=true;

    @JsonProperty("designation")
    private Designation designation;

    @JsonProperty(value = "image")
    private byte[] image;

    public UserDTO(int userId, String email, String password) {
        this.userId=userId;
        this.email=email;
        this.password=password;
    }
}