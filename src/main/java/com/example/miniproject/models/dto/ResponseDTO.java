package com.example.miniproject.models.dto;

import com.example.miniproject.models.entity.Designation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    @NotNull
    @JsonProperty(value = "user_id")
    private int userId;

    @JsonProperty("emp_id")
    private int employeeId;

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

    @JsonProperty(value = "active")
    private boolean active;

    @JsonProperty("designation")
    private Designation designation;

    @JsonProperty(value = "image")
    private byte[] image;

    @JsonProperty(value = "dept_id")
    private int departmentId;

    @JsonProperty(value = "salary_id")
    private int salaryId;
}
