package com.example.miniproject.models.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name = "aadhar_number")
    private String aadharNumber;

    @Column(name="pan_number")
    private String panNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_ifsc_code")
    private String banKIfscCode;

    @Column(name = "active")
    private boolean active;

    @Column(name = "role")
    private String role;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
