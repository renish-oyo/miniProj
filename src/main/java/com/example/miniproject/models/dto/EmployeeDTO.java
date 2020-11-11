package com.example.miniproject.models.dto;

import com.example.miniproject.models.entity.Designation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {

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
    @Enumerated(EnumType.STRING)
    private Designation designation;

    @JsonProperty("dept_id")
    private int departmentId;

    @JsonProperty("salary_id")
    private int salaryId;

    @CreationTimestamp
    @JsonProperty(value = "create_date")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @JsonProperty(value = "update_date")
    private LocalDateTime updateDateTime;

    @JsonProperty(value = "image")
    private byte[] image;

}